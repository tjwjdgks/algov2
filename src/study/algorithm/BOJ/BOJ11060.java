package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11060 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        int [] dp =  new int[N];
        Arrays.fill(dp,Integer.MAX_VALUE/2);
        dp[0] = 0;
        for(int i=0;i<arr.length-1;i++){
            int curJemp = arr[i];
            for(int j=1;j<=curJemp;j++){
                if(i+j<N){
                    dp[i+j] = Math.min(dp[i]+1,dp[i+j]);
                }
            }
        }
        if(dp[N-1] == Integer.MAX_VALUE/2){
            System.out.println(-1);
        }
        else{
            System.out.println(dp[N-1]);
        }
    }
}
