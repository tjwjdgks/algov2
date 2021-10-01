package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 동전의 갯수 구하기 중복되지 않고 사용할 수 있는 갯수 구하기
/*
public class BOJ2294 {
    public static final int MAX = 10_000;
    public static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            set.add(num);
        }
        long [][] dp = new long[k+1][set.size()];
        dp[0][0] = 1;
        for(int i=1; i<= k; i++){
            int count =0;
            for(int j : set){
                if(i<j) break;
                for(int c = 0; c<=count;c++){
                    dp[i][count] += dp[i-j][c];
                }
                count++;
            }
        }
        long total = 0;
        for(int i=0;i<set.size();i++){
            total += dp[k][i];
        }
        if(total == 0 )
            System.out.println(-1);
        else
            System.out.println(total);
    }
}
 */

//
public class BOJ2294 {
    public static final int MAX = 10_000;
    public static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            set.add(num);
        }
        long [] dp = new long[k+1];
        Arrays.fill(dp,Integer.MAX_VALUE/2);
        dp[0] = 0;
        for(int i=1;i<=k;i++){
            for(int j : set){
                if(i<j) break;
                dp[i] = Math.min(dp[i],dp[i-j]+1);
            }
        }
        if(dp[k] == Integer.MAX_VALUE/2)
            System.out.println(-1);
        else System.out.println(dp[k]);
    }
}