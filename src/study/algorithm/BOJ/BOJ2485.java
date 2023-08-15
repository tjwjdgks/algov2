package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] array = new long[N];
        for(int i=0;i<N;i++){
            array[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(array);
        List<Long> list = new ArrayList<>();
        for(int i=0;i<array.length-1;i++){
            list.add(array[i+1]-array[i]);
        }
        list.sort(Collections.reverseOrder());
        long gcd = getGCD(list.get(0), list.get(1));
        for(long i : list){
            long c = Math.max(gcd, i);
            long d = Math.min(gcd, i);
            gcd = getGCD(c,d);
        }
        long answer = 0;
        for(long i : list){
            answer += (i/gcd)-1;
        }
        System.out.println(answer);
    }

    public static long getGCD(long a, long b) {
        if(b==0) return a;
        return getGCD(b, a%b);
    }
}
