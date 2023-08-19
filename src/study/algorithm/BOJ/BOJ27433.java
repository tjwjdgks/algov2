package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ27433 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long s = factory(N);
        System.out.println(s);
    }

    private static long factory(int n) {
        if(n == 0) return 1;
        return n*factory(n-1);
    }
}
