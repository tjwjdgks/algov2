package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] array = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        int [] dp = new int[array.length];
        for(int i=0;i<N;i++){
            dp[i] = 1;
            for(int j=i-1; j>=0;j--){
                if(array[i] > array[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int answer = 0;
        for(int i=0;i<N;i++){
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
