package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 중복제거 유형은 오름차순으로 점화식을 찾아 해결 하기
public class BOJ15989 {
    public static final int MAX = 10_001;
    public static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        int [] arr = new int[T];
        for(int i=0;i<T;i++)
            arr[i] = Integer.parseInt(br.readLine());

        // 오름 차순으로만 더할 수 있다
        // 정수 i를 만들때 마지막으로 더한 수 가 (j+1)인 경우의 수
        long [][] dp = new long[MAX][3];
        dp[0][0] = 1;
        for(int i=1;i<=10000;i++){
            dp[i][0] = dp[i-1][0];
            if(i>1)
                dp[i][1] = dp[i-2][0] + dp[i-2][1];
            if(i>2)
                dp[i][2] = dp[i-3][0] + dp[i-3][1] + dp[i-3][2];
        }
        for(int i : arr){
            long total = dp[i][0] + dp[i][1] + dp[i][2];
            sb.append(total).append("\n");
        }
        System.out.println(sb.toString());
    }
}
