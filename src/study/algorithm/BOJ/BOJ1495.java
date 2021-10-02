package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1495 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();

        int [] dp = new int[M+1];
        for(int i =0;i<arr.length;i++){
            if(i == 0){
                int plusNum = S+arr[0];
                int minusNum = S-arr[0];
                if(plusNum<=M)
                    dp[plusNum] = 1;
                if(minusNum>=0)
                    dp[minusNum] = 1;
            }
            else{
                int [] tempdp = new int[M+1];
                for(int j=0;j<dp.length;j++){
                    if(dp[j] == i){
                        int plusNum = j+arr[i];
                        int minusNum = j-arr[i];
                        if(plusNum<=M)
                            tempdp[plusNum] = i+1;
                        if(minusNum>=0)
                            tempdp[minusNum] = i+1;
                    }
                }
                dp = tempdp;
            }
        }
        int answer = -1;
        for(int i=dp.length-1;i>=0;i--){
            if(dp[i] == N){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
