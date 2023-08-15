package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ24267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long total = 0;
        for(int i=1;i<=N-2;i++){
            total += (long)(i+1)*i/2;
        }
        System.out.println(total);
        System.out.println(3);
    }
}