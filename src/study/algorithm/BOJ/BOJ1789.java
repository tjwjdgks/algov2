package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1789 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long count = 0;
        long num = 1;
        while(N>=0){
            N -= num;
            num++;
            count++;
        }
        System.out.println(count-1);
    }
}
