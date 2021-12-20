package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17086 {
    public static void getAnswer() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] table = new int[N][M];
        boolean [][] area = new boolean[N][M];
        int [] dy = {-1,-1,-1,0,0,1,1,1};
        int [] dx = {-1,0,1,-1,1,-1,0,1};
        for(int i=0;i<N;i++){
            table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(table[i][j] == 1){
                    queue.add(new int[]{i,j,0});
                    area[i][j] = true;
                }
            }
        }
        int maxAnswer  = 0;
        while(!queue.isEmpty()){
            int[] curindex = queue.poll();
            maxAnswer= Math.max(maxAnswer,curindex[2]);
            for(int i=0;i<8;i++){
                int tempy = curindex[0] + dy[i];
                int tempx = curindex[1] + dx[i];
                if(tempx>=0 && tempy>=0 && tempx<M && tempy<N && !area[tempy][tempx] ){
                    area[tempy][tempx] = true;
                    queue.add(new int[]{tempy,tempx,curindex[2]+1});
                }
            }
        }
        System.out.println(maxAnswer);
    }
}
