package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10942 {
    public void getAnswer() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        boolean [][] dp = new boolean[N][N];
        for(int i=0; i<N;i++){
            dp[i][i] = true;
        }
        for(int i = 1; i<N;i++){
            for(int j=0; j<N-i;j++){
                if(arr[j] == arr[j+i]){
                    if(i == 1) {
                        dp[j][j+i] = true;
                        continue;
                    }
                    if(dp[j+1][j+i-1]){
                        dp[j][j+i] = true;
                    }
                    else dp[j][j+i] = false;
                }
                else{
                    dp[j][j+i] = false;
                }
            }
        }
        int M = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<M;i++){
            st= new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            if(dp[start][end])
                sb.append("1\n");
            else
                sb.append("0\n");
        }
        System.out.println(sb.toString());
    }
}
