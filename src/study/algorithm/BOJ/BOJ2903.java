package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2903 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long before = 2;
        long cur = -1;
        for(int i=0;i<N;i++){
            cur = before*2-1;
            before = cur;
        }
        System.out.println(cur*cur);
    }
}
