package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ13241 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long [] array = Arrays.stream(br.readLine().split(" ")).mapToLong(i->Long.parseLong(i)).sorted().toArray();

        long c = pcb(array[1], array[0]);
        System.out.println(array[0]/c*array[1]);
    }

    private static long pcb(long l, long l1) {
        if(l1 == 0)
            return l;
        return pcb(l1, l%l1);
    }
}
