package study.algorithm.PROGRAMMERS;

public class wayToSchool {
    public static final int MOD = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        boolean [][] checks = new boolean[m][n];
        for(int i=0;i<puddles.length;i++){
            checks[puddles[i][0]-1][puddles[i][1]-1] = true;
        }
        long [][] dp = new long[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j ==0) dp[i][j] = 1;
                else if(i == 0){
                    dp[i][j] = dp[i][j-1];
                }
                else if(j == 0){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
                if(checks[i][j])
                    dp[i][j] = 0;
                else
                    dp[i][j] %= MOD;
            }
        }
        answer = (int)dp[m-1][n-1];
        return answer;
    }
}
