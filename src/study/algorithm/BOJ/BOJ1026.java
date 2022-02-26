package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1026 {
    public static void getAnswer() throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arrA = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        int [] arrB = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();

        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int total = 0;
        for(int i=0;i<N;i++){
            total += arrA[i] * arrB[N-1-i];
        }
        System.out.println(total);
    }
}
