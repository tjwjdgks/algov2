package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14442 {
    public static int [] dy = {0,1,0,-1};
    public static int [] dx = {1,0,-1,0};
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][];
        for(int i=0;i<N;i++)
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(k->Integer.parseInt(k)).toArray();

        int[][][] dp = new int[K+1][N][M];

        int minDist = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0,0,0,1});
        dp[0][0][0] = 1;
        while(!queue.isEmpty()){
            int [] curidx=  queue.poll();
            if(curidx[0] == N-1 && curidx[1] == M-1){
                minDist = Math.min(minDist,curidx[3]);
                break;
            }
            for(int i=0;i<4;i++){
                int tempy = curidx[0]+dy[i];
                int tempx = curidx[1]+dx[i];
                if(tempy>=0 && tempy<N && tempx>=0 && tempx<M){
                    if(dp[curidx[2]][tempy][tempx] != 0) continue;

                    if(arr[tempy][tempx] == 0){
                        dp[curidx[2]][tempy][tempx] = curidx[3]+1;
                        queue.add(new int[]{tempy,tempx,curidx[2],curidx[3]+1});
                    }
                    if(arr[tempy][tempx] ==1 && curidx[2]<K){
                        dp[curidx[2]+1][tempy][tempx] = curidx[3]+1;
                        queue.add(new int[]{tempy,tempx,curidx[2]+1,curidx[3]+1});
                    }

                }
            }
        }
        if(minDist==Integer.MAX_VALUE)
            System.out.println(-1);
        else System.out.println(minDist);
    }
}
