package study.algorithm.study.dk.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class June {
    public static int [] dy = {0,1,0,-1};
    public static int [] dx = {1,0,-1,0};
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] area = new int[N][];
        int [][] areaCount = new int[N][N];
        for(int i=0;i<N;i++){
            area[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        }
        initArea(N,area,areaCount);
        coverArea(N,area,areaCount);
        int answer = compareMinArea(N,area,areaCount);
        System.out.println(answer);
    }

    private static int compareMinArea(int N, int[][] area, int[][] areaCount) {
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<4;k++){
                    int tempy = i + dy[k];
                    int tempx = j + dx[k];
                    if(isIn(tempy,tempx,N) && area[i][j] != area[tempy][tempx]){
                        answer = Math.min(answer, areaCount[i][j] + areaCount[tempy][tempx]);
                    }
                }
            }
        }
        return answer;
    }

    private static void coverArea(int N, int[][] area, int[][] countArea) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(area[i][j] !=0){
                    queue.add(new int[]{i,j,area[i][j],0});
                }
            }
        }
        dfs(N,area,countArea,queue,0,false);
    }

    private static void initArea(int N, int[][] area, int[][] countArea) {
        int areaCount = 2;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(area[i][j] == 1){
                    Queue<int[]> queue = new LinkedList<>();
                    area[i][j] = areaCount++;
                    queue.add(new int[]{i,j,area[i][j],0});
                    dfs(N,area,countArea,queue,1,true);
                }
            }
        }
    }
    private static boolean isIn(int y, int x, int N){
        return y>=0&& x>=0&& y<N && x<N;
    }
    private static void dfs(int N, int [][] area, int[][] countArea, Queue<int[]> queue, int targetNum, boolean init){
        while(!queue.isEmpty()){
            int [] curIndex = queue.poll();
            countArea[curIndex[0]][curIndex[1]] = init ? 0 : curIndex[3];

            for(int i=0;i<4;i++){
                int tempy = curIndex[0] + dy[i];
                int tempx = curIndex[1] + dx[i];
                if(isIn(tempy,tempx,N) && area[tempy][tempx] == targetNum){
                    area[tempy][tempx] = curIndex[2];
                    queue.add(new int[]{tempy,tempx,curIndex[2],curIndex[3]+1});
                }
            }
        }
    }

    public static void main(String []args) throws IOException {
        getAnswer();
    }
}
