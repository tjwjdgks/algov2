package study.algorithm.study.dk.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bear {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        boolean [][] dp = new boolean[N+1][M+1];
        dp[0][S] = true;
        for(int i=1;i<=N;i++){
            int gap = arr[i-1];
            for(int j=0;j<=M;j++){
                if(dp[i-1][j] == true){
                    if(j-gap>=0) dp[i][j-gap] = true;
                    if(j+gap<=M) dp[i][j+gap] = true;
                }
            }
        }
        int answer = -1;
        for(int i=0;i<=M;i++){
            if(dp[N][i]) answer = i;
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        getAnswer();
    }
}
