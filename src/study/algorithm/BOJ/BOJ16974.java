package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16974 {
    public static long [] hb = new long[51];
    public static long [] p = new long[51];
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());
        hb[0] = 1;
        p[0] = 1;

        for(int i=1;i<=N;i++){
            hb[i] = 2*hb[i-1] +3;
            p[i] = 2*p[i-1] +1;
        }
        long answer = dfs(N,X);
        System.out.println(answer);
    }

    private static long dfs(int n, long x) {
        if(n == 0){
            if(x == 0) return 0;
            return 1;
        }
        if(x== 1) return 0;
        else if(x <=hb[n-1]+1){
            return dfs(n-1,x-1);
        }
        else if(x== 1+hb[n-1]+1){
            return p[n-1]+1;
        }
        else if(x<=1+hb[n-1]+1+hb[n-1]){
            return 1+p[n-1] + dfs(n-1,x-1-hb[n-1]-1);
        }
        else return p[n];
    }
}
