package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ16967 {
    public static int [][] answerTable;
    public static int [][] table;
    public static int H,W,X,Y;
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] information = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        H = information[0];
        W = information[1];
        X = information[2];
        Y = information[3];
        answerTable = new int[H][W];
        table = new int[H+X][W+Y];
        for(int i=0;i<H+X;i++)
            table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        calculate();
        print();
    }
    private static void calculate(){
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(i-X<0 || j-Y<0) answerTable[i][j] = table[i][j];
                else answerTable[i][j] = table[i][j] - answerTable[i-X][j-Y];
            }
        }
    }
    private static void print(){
        StringBuffer sb= new StringBuffer();
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                sb.append(answerTable[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
