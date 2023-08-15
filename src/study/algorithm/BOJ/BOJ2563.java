package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2563 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean [][] array = new boolean[101][101];
        for(int i=0;i<N;i++){
            String [] s = br.readLine().split(" ");
            int left = Integer.parseInt(s[0]);
            int bottom = Integer.parseInt(s[1]);
            for(int j=0;j<10;j++){
                for(int k=0;k<10;k++){
                    array[bottom+j][left+k] = true;
                }
            }
        }
        int answer = 0;
        for(int i=0;i<=100;i++){
            for(int j=0;j<=100;j++){
                if(array[i][j]) answer++;
            }
        }
        System.out.println(answer);
    }
}
