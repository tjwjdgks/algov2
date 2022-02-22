package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ24499 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();

        int totalMax = 0;
        int sum = 0;
        for(int i=0;i<K;i++){
            sum += arr[i];
        }
        totalMax = Math.max(totalMax,sum);
        for(int i=K;i<N+K;i++){
            sum += arr[i%N];
            sum -= arr[i-K];
            totalMax = Math.max(totalMax,sum);
        }
        System.out.println(totalMax);
    }
}
