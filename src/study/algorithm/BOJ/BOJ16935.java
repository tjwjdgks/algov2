package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16935 {
    public static int [][] tables;
    public static int []functionArr;
    public static void print(int N, int M){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sb.append(tables[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void applyFunction(int F){
        int N = tables.length;
        int M = tables[0].length;
        switch (F){
           case 1 :
               tables = upDown(N,M);
               break;
           case 2 :
               tables = leftRight(N,M);
               break;
           case 3 :
               tables = rotateRight(N,M);
               break;
           case 4 :
               tables = rotateLeft(N,M);
               break;
           case 5 :
               tables = moveFront(N,M);
               break;
           case 6 :
               tables = moveBack(N,M);
               break;
       }
    }
    public static void move(int [][] curTable, int curArea, int tArea){
        int cury=0,curx=0;
        int standy=0,standx=0;
        if(curArea/2 == 1)
            cury += curTable.length/2;
        if(curArea == 1 || curArea== 2)
            curx += curTable[0].length/2;
        if(tArea/2 == 1)
            standy += curTable.length/2;
        if(tArea ==1 || tArea == 2)
            standx += curTable[0].length/2;

        for(int i=0;i<curTable.length/2;i++){
            for(int j=0;j<curTable[0].length/2;j++){
                curTable[cury+i][curx+j] = tables[standy+i][standx+j];
            }
        }
    }
    private static int[][] moveFront(int N, int M) {
        int [][] curTable = new int[N][M];
        move(curTable,0,3);
        move(curTable,1,0);
        move(curTable,2,1);
        move(curTable,3,2);
        return curTable;
    }
    private static int[][] moveBack(int N, int M) {
        int [][] curTable = new int[N][M];
        move(curTable,0,1);
        move(curTable,1,2);
        move(curTable,2,3);
        move(curTable,3,0);
        return curTable;
    }
    private static int[][] rotateRight(int N, int M) {
        int [][] curTable = new int[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                curTable[i][j] = tables[N-1-j][i];
            }
        }
        return curTable;
    }
    public static int[][] rotateLeft(int N,int M){
        int [][] curTable = new int[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                curTable[i][j] = tables[j][M-1-i];
            }
        }
        return curTable;
    }

    private static int[][] upDown(int N, int M){
        int [][] curTable = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                curTable[i][j] = tables[N-1-i][j];
            }
        }
        return curTable;
    }
    private static int[][] leftRight(int N, int M) {
        int [][] curTable = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                curTable[i][j] = tables[i][M-1-j];
            }
        }
        return curTable;
    }

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        tables = new int[N][];
        for(int i=0;i<N;i++)
            tables[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(num->Integer.parseInt(num)).toArray();
        functionArr = Arrays.stream(br.readLine().split(" ")).mapToInt(num->Integer.parseInt(num)).toArray();

        for(int i=0;i<R;i++)
            applyFunction(functionArr[i]);
        print(tables.length,tables[0].length);
    }
}
