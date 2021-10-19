package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10824 {

    public static void getAnswer() throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        long[] numArr = Arrays.stream(br.readLine().split(" ")).mapToLong(i->Long.parseLong(i)).toArray();
        long first = Long.parseLong(numArr[0]+""+numArr[1]);
        long second = Long.parseLong(numArr[2]+""+numArr[3]);
        System.out.println(first+second);
    }
}
