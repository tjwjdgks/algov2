package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2559 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();

        int total = 0;
        int maxTotal = 0;
        for(int i=0;i<M;i++){
            total += arr[i];
            maxTotal += arr[i];
        }
        for(int i=M;i<N;i++){
            total -= arr[i-M];
            total += arr[i];
            maxTotal = Math.max(total,maxTotal);
        }
        System.out.println(maxTotal);
    }
}
