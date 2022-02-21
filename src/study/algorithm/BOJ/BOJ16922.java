package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16922 {
    public static boolean [] dp = new boolean[1001];
    public static int count = 0;

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<=N;i++){
            for(int v=0;v<=N-i;v++){
                for(int x=0;x<=N-i-v;x++){
                    int l = N -i -v-x;
                    int total = 1*i + 5*v + 10*x + 50*l;
                    if(!dp[total]) {
                        count++;
                        dp[total] = true;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
