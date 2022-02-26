package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2468 {
    public static int [] dy = {0,1,0,-1};
    public static int [] dx = {1,0,-1,0};
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] table=  new int[N][];
        for(int i=0;i<N;i++){
            table[i]= Arrays.stream(br.readLine().split(" ")).mapToInt(num->Integer.parseInt(num)).toArray();
        }
        int maxHeight = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                maxHeight  = Math.max(maxHeight,table[i][j]);
            }
        }
        int maxAreaCount = 1;
        for(int i=1;i<maxHeight;i++){
            maxAreaCount = Math.max(getCount(N,table,i),maxAreaCount);
        }
        System.out.println(maxAreaCount);
    }

    private static int getCount(int N,int[][] table, int num) {
        int [][] tempTable = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                tempTable[i][j] = table[i][j] - num;
            }
        }
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(tempTable[i][j] >0){
                    count++;
                    tempTable[i][j] = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int [] curIdx = queue.poll();
                        for(int k=0;k<4;k++){
                            int tempy = curIdx[0] + dy[k];
                            int tempx = curIdx[1] + dx[k];
                            if(tempy>=0 && tempy<N && tempx>=0 && tempx<N && tempTable[tempy][tempx]>0){
                                queue.add(new int[]{tempy,tempx});
                                tempTable[tempy][tempx] = 0;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
