package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2475 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int reduce = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> (int) Math.pow(Integer.parseInt(i), 2)).reduce(0, (a, b) -> (a + b) % 10);
        System.out.println(reduce);
    }
}
