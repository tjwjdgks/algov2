package study.algorithm.study.dk.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bear {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        int [] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=N;i++){
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }
        System.out.println(dp[N]);
    }
    public static void main(String [] args) throws IOException {
        getAnswer();
    }
}
