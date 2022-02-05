package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1080 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());

        int [][] originalTable = new int[N][];
        int [][] changedTable = new int[N][];

        for(int i=0;i<N;i++){
            originalTable[i] = Arrays.stream(br.readLine().split("")).mapToInt(num->Integer.parseInt(num)).toArray();
        }
        for(int i=0; i<N;i++){
            changedTable[i] = Arrays.stream(br.readLine().split("")).mapToInt(num->Integer.parseInt(num)).toArray();
        }
        boolean flag = true;
        int total = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(originalTable[i][j] != changedTable[i][j]){
                    if(i+2<N && j+2<M){
                        total++;
                        chageTable(originalTable,i,j);
                    }
                    else{
                        flag = false;
                    }
                }
            }
        }
        if(!flag)
            System.out.println(-1);
        else
            System.out.println(total);
    }

    private static void chageTable(int[][] originalTable, int i, int j) {
        for(int y = i;y<i+3;y++){
            for(int x = j;x<j+3;x++){
                originalTable[y][x] = Math.abs(originalTable[y][x] - 1);
            }
        }
    }
}
