package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ5557 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();

        long [][] dp = new long[N][21];
        dp[0][arr[0]] = 1;
        long answer = 0;
        for(int i=1;i<N-1;i++){
            for(int j=0;j<=20;j++){
                if(dp[i-1][j] != 0){
                    int plusnum = j+arr[i];
                    int minusnum = j-arr[i];
                    if(plusnum<=20)
                        dp[i][plusnum] += dp[i-1][j];
                    if(minusnum>=0)
                        dp[i][minusnum] += dp[i-1][j];
                }
            }
        }
        answer = dp[N-2][arr[N-1]];
        System.out.println(answer);
    }
}
