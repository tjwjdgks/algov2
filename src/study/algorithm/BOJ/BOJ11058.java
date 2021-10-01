package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11058 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] dp = new long[101];
        dp[0] = 0;
        for(int i=1;i<=N;i++){
            dp[i] = dp[i-1]+1;
            for(int j=3;j<i;j++){
                long num = dp[i-j]*(j-1);
                dp[i] = Math.max(num,dp[i]);
            }
        }
        System.out.println(dp[N]);
    }
}
