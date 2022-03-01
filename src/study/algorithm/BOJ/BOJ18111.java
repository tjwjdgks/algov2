package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18111 {
    public static void getAnswer() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        final int MIN = 0;
        final int MAX = 256;
        int[][] table = new int[N][];

        for(int i=0;i<N;i++)
            table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(k->Integer.parseInt(k)).toArray();

        int minIdx = 0;
        int minTime = Integer.MAX_VALUE;
        for(int i=MIN; i<=MAX; i++){
            int area = getArea(table,K,i);
            if(area == Integer.MAX_VALUE) break;
            if(area<=minTime){
                minTime= area;
                minIdx = i;
            }
        }
        System.out.println(minTime+" "+minIdx);
    }

    private static int getArea(int[][] table, int restBlock, int height) {
        int minusBlock = 0;
        int plusBlock = 0;
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table[0].length;j++){
                if(table[i][j]<height){
                    plusBlock += height - table[i][j];
                }
                else{
                    minusBlock += table[i][j] - height;
                }
            }
        }
        if(restBlock+minusBlock<plusBlock) return Integer.MAX_VALUE;
        return minusBlock*2+plusBlock;
    }
}
