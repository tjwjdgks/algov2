package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ24416 {

    public static long a = 0;
    public static long fib(long n){
        if(n  == 2 || n == 1) {
            a++;
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        fib(n);
        System.out.println(a+ " "+(n-2));
    }
}
