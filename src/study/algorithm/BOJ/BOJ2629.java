package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ2629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] array = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        int M = Integer.parseInt(br.readLine());
        int [] ball = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        boolean [] dp = new boolean[40_001];

        dp[0] = true;
        for(int i=0;i<N;i++){
            boolean [] temp = new boolean[40_001];
            for(int j=0;j<dp.length;j++){
                if(dp[j] == true){
                    temp[j] = true;
                    temp[Math.abs(j-array[i])] = true;
                    if(j+array[i]<dp.length){
                        temp[j+array[i]] = true;
                    }
                }
            }
            dp = temp;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<ball.length;i++){
            if(dp[ball[i]]){
                sb.append("Y ");
            }
            else sb.append("N ");
        }
        System.out.println(sb.toString());
    }
}
