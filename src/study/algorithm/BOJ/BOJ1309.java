package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1309 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MOD = 9901;
        // none left right
        int [][] dp = new int[100_001][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for(int i=2;i<=N;i++){
            dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2])% MOD;
            dp[i][1] = (dp[i-1][0]+dp[i-1][2])%MOD;
            dp[i][2] = (dp[i-1][0]+dp[i-1][1])%MOD;
        }
        System.out.println((dp[N][0]+dp[N][1]+dp[N][2])%MOD);
    }
}
