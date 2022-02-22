package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ24498 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(i->Long.parseLong(i)).toArray();

        if(N == 1){
            System.out.println(arr[0]);
            return;
        }
        long maxNum  = Math.max(arr[0],arr[N-1]);
        for(int i=1;i<N-1;i++){
            long num = Math.min(arr[i-1],arr[i+1]);
            long curMax = num + arr[i];
            if(curMax>maxNum)
                maxNum = curMax;
        }
        System.out.println(maxNum);
    }
}
