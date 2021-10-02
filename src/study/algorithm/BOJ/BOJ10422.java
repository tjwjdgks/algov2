package study.algorithm.BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
카탈란 수 문제 or dp로 가능 but 문제 항이 높으므로 dp
재귀, for 문
 */
public class BOJ10422 {
    public static final long DIV = 1_000_000_007;
    public static final int L = 5_000;
    public static long [] dp = new long[L+1];
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        int [] arr =new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        dp[2] = 1;
        // 여는 괄호와 대응되는 닫는 괄호가 j 번째 위치 (---)[    ] 기준 괄호 빼므로 -2
        // [] 경우 n에서 j 만큼 빠짐
        // mod 연산 주의
        for(int i=3; i<=L;i++){
            for(int j=2;j<=i;j++){
                dp[i] += dp[j-2]*   dp[i-j];
            }
            dp[i] %= DIV;
        }
        for(int i=0;i<arr.length;i++){
            sb.append(dp[arr[i]]).append("\n");
        }
        System.out.println(sb.toString());
        // dfs 시
        //Arrays.fill(dp,-1);
        // System.out.println ~~~~
    }
    public static long dfs(int l){
        if(l == 0) return 1;
        if(dp[l]>=0) return dp[l];
        dp[l] = 0;
        for(int i=2;i<l;i+=2){
            dp[l] += dfs(i-2) * dfs(l-i);
            dp[l] %= DIV;
        }
        return dp[l];
    }
}
