package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ3566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [][] array = new int[9][9];
        for(int i=0;i<9;i++){
            array[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        }
        int maxVal =-1;
        int row = -1;
        int col = -1;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(maxVal < array[i][j]){
                    maxVal=  array[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println(maxVal);
        System.out.println((row+1)+" "+(col+1));
    }
}
