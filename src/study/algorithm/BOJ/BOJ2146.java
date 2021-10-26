package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2146 {
    public static int [] dy = {0,0,1,-1};
    public static int [] dx = {1,-1,0,0};

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [][] area = new int[N][];
        for(int i=0;i<N;i++){
            area[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(k->Integer.parseInt(k)).toArray();
        }

        int [][] dvideArea = new int[N][N];
        boolean [][] checks = new boolean[N][N];
        int areaCount = 0;
        // divide area
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(area[i][j] !=0 && !checks[i][j]){
                    areaCount++;
                    checks[i][j] = true;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int [] curidx = queue.poll();
                        dvideArea[curidx[0]][curidx[1]] = areaCount;
                        for(int k=0;k<4;k++){
                            int tempy = curidx[0]+dy[k];
                            int tempx = curidx[1] +dx[k];
                            if(tempy>=0 && tempy<N && tempx>=0 && tempx<N){
                                if(!checks[tempy][tempx] && area[tempy][tempx] !=0){
                                    checks[tempy][tempx] = true;
                                    queue.add(new int[]{tempy,tempx});
                                }
                            }
                        }
                    }
                }
            }
        }
        int answer =Integer.MAX_VALUE;
        // calc
        for(int i=1;i<=areaCount;i++){
            answer = Math.min(answer,getAnswer(dvideArea,i,N));
        }
        System.out.println(answer);


    }
    public static int getAnswer(int[][] area, int areaindex,int N){
        boolean [][] checks = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(area[i][j] == areaindex){
                    queue.add(new int[]{i,j,0});
                    checks[i][j]= true;
                }
            }
        }
        while(!queue.isEmpty()){
            int [] curidx = queue.poll();
            for(int i=0;i<4;i++){
                int tempy = curidx[0]+dy[i];
                int tempx = curidx[1]+dx[i];
                if(tempy>=0 && tempx>=0 && tempy<N && tempx<N){
                    if(checks[tempy][tempx]) continue;
                    if(area[tempy][tempx] == 0){
                        checks[tempy][tempx] = true;
                        queue.add(new int[]{tempy,tempx,curidx[2]+1});
                    }
                    else{
                        return curidx[2];
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
