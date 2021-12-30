package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BOJ1600 {
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};


    public static int jumpy[] = {-1,-2,-2,-1,1,2,2,1};
    public static int jumpx[] = {-2,-1,1,2,2,1,-1,-2};
    private static int K,W,H;
    private static int [][] table;
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        table = new int[H][];
        for(int i=0;i<H;i++)
            table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(num->Integer.parseInt(num)).toArray();

        int answer = dfs();
        System.out.println(answer);
    }

    private static int dfs() {
        boolean check[][][] = new boolean[H][W][K+1];
        Queue<int[]> queue = new LinkedList<>();
        check[0][0][0] = true;
        // y,x, jumpCount, totalCount
        queue.add(new int[]{0,0,0,0});

        while(!queue.isEmpty()){
            int[] curIdx = queue.poll();
            if(curIdx[0] == H-1 && curIdx[1] == W-1){
                return curIdx[3];
            }
            if(curIdx[2]<=K-1) doJump(queue,check,curIdx);
            doMove(queue,check,curIdx);
        }
        return -1;
    }
    private static boolean checkIndex(int y, int x, int jumpCount, boolean[][][] check){
        return y>=0 && x>= 0&& y<H && x<W && !check[y][x][jumpCount] && table[y][x] != 1;
    }
    private static void doMove(Queue<int[]> queue, boolean[][][] check, int[] curIdx) {
        for(int i=0;i<4;i++){
            int tempy = curIdx[0] + dy[i];
            int tempx = curIdx[1] + dx[i];
            if(checkIndex(tempy,tempx,curIdx[2],check)){
                check[tempy][tempx][curIdx[2]] = true;
                queue.add(new int[]{tempy,tempx,curIdx[2],curIdx[3]+1});
            }
        }
    }

    private static void doJump(Queue<int[]> queue, boolean[][][] check, int[] curIdx){
        for(int i=0;i<8;i++){
            int tempy = curIdx[0] + jumpy[i];
            int tempx = curIdx[1] + jumpx[i];
            int tempJumpCount = curIdx[2]+1;
            if(checkIndex(tempy,tempx,tempJumpCount,check)){
                check[tempy][tempx][tempJumpCount] = true;
                queue.add(new int[]{tempy,tempx,tempJumpCount,curIdx[3]+1});
            }
        }
    }
}
