package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17427 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        long answer = 0;
        for(int i=1;i<=num;i++){
            answer += (num/i)*i;
        }
        System.out.println(answer);
    }
}
