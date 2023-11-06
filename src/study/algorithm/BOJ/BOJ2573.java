package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2573 {
    public static int [] dy = {0,1,0,-1};
    public static int [] dx = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] table = new int[N][M];
        for(int i=0;i<N; i++) {
            table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
        }

        int year = 0;
        for(year=0; year<=10000; year++){
            int count = 0;
            boolean[][] check = new boolean[N][M];
            for(int i=0;i<N;i++){
                for(int j=0; j<M;j++){
                    if(table[i][j] != 0 && check[i][j] == false){
                        count++;
                        if(count >=2){
                            System.out.println(year);
                            return;
                        }
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i,j});
                        while(!queue.isEmpty()){
                            int [] index = queue.poll();
                            for(int k=0;k<4;k++){
                                int tempy = index[0] + dy[k];
                                int tempx = index[1] + dx[k];
                                if(tempy>=0 && tempx>=0 && tempy<N && tempx<M && table[tempy][tempx] !=0 && !check[tempy][tempx]){
                                    check[tempy][tempx] = true;
                                    queue.add(new int[]{tempy,tempx});
                                }
                            }
                        }
                    }
                }
            }
            boolean allZero = true;
            int [][] tempTable =  new int[N][M];
            for(int i=0;i<N;i++){
                for(int j=0; j<M;j++){
                    if(table[i][j] == 0) continue;
                    allZero = false;
                    int meltCount = 0;
                    for(int k=0; k<4; k++){
                        int tempy = i + dy[k];
                        int tempx = j + dx[k];
                        if(tempy>=0 && tempx>=0 && tempy<N && tempx<M && table[tempy][tempx] ==0 ){
                            meltCount++;
                        }
                    }
                    tempTable[i][j] = Math.max(table[i][j] - meltCount, 0);
                }
            }
            table = tempTable;
            if(allZero) {
                 System.out.println(0);
                 return;
            }
        }
    }
}
