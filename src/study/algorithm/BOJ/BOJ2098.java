package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 외판원 순회 문제 비트 마스크 공부
 */
public class BOJ2098 {
    public static int N;
    public static int[][] edges;
    public static int[][] dp;
    public static final int INF = 987654321;
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        edges = new int[N][];
        for(int i=0;i<N;i++){
            edges[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(k->Integer.parseInt(k)).toArray();
        }
        dp = new int[N][(1<<N)-1];
        for(int i=0;i<N;i++)
            Arrays.fill(dp[i],-1);
        int answer = dfs(0,1);
        System.out.println(answer);
    }
    public static int dfs(int step, int flag){
        if(flag == (1<<N)-1){
            if(edges[step][0] ==0) return INF;
            else return edges[step][0];
        }
        if(dp[step][flag] != -1)
            return dp[step][flag];
        dp[step][flag] = INF;
        for(int i=0;i<N;i++){
            if((flag & (1<<i)) == 0 && edges[i][step]!=0){
                dp[step][flag] = Math.min(dp[step][flag], dfs(i,flag | (1<<i)) + edges[step][i]);
            }
        }
        return dp[step][flag];
    }
}
