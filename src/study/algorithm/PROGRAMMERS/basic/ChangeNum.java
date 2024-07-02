package study.algorithm.PROGRAMMERS.basic;

import java.util.Arrays;

public class ChangeNum {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int [] dp = new int[y+1];
        Arrays.fill(dp, Integer.MAX_VALUE/2);
        dp[x] = 0;
        for(int i=x; i<=y; i++){
            if(i-n>=0) {
                dp[i] = Math.min(dp[i], dp[i-n]+1);
            }
            if(i%2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }
            if(i%3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
        }
        return dp[y] == Integer.MAX_VALUE/2 ? -1 : dp[y];
    }
}
