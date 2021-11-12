package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17425 {
    public static final int MAX = 1_000_000;
    public static long [] totalarr = new long[MAX+1];
    public static void init(){
        long [] arr = new long[MAX+1];
        for(int i=1;i<=MAX;i++){
            for(int j=i;j<=MAX;j+=i){
                arr[j] += i;
            }
        }
        for(int i=1;i<=MAX;i++){
            totalarr[i] = totalarr[i-1]+arr[i];
        }
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        init();

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int curNum = Integer.parseInt(br.readLine());
            sb.append(totalarr[curNum]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
