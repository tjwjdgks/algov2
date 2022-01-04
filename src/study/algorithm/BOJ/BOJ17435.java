package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17435 {
    public static final int MAXNUM = 500_000;
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb= new StringBuffer();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int maxDepth = (int)(Math.log(MAXNUM)/Math.log(2));
        int [][] dp = new int[maxDepth+1][N+1];

        st= new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++)
            dp[0][i] = Integer.parseInt(st.nextToken());

        for(int i=1;i<=maxDepth;i++){
            for(int j=1;j<=N;j++){
                dp[i][j] = dp[i-1][dp[i-1][j]];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            for(int j = maxDepth;j>=0;j--){
                int tempE = (int)Math.pow(2,j);
                if(tempE<=n){
                    x = dp[j][x];
                    n -= tempE;
                }
            }
            sb.append(x).append("\n");
        }

        System.out.println(sb.toString());
        br.close();

    }
}
