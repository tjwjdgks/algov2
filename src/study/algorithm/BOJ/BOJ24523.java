package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ24523 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();

        int idx = 0;
        int count = 1;
        StringBuffer sb = new StringBuffer();
        while(idx<N){
            int num = arr[idx];
            int i = idx;
            for(i=idx+1;i<N;i++){
                if(num != arr[i]){
                    break;
                }
                count++;
            }
            for(int k=0;k<count;k++){
                if(i<N)
                    sb.append(i+1).append(" ");
                else
                    sb.append(-1).append(" ");
            }
            idx = i;
            count = 1;
        }
        System.out.println(sb.toString());
    }
}
