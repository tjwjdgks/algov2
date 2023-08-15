package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a1 = Long.parseLong(st.nextToken());
        long b1 = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long a2 = Long.parseLong(st.nextToken());
        long b2 = Long.parseLong(st.nextToken());
        long c = Math.max(b1, b2);
        long d = Math.min(b1, b2);
        long e = gcd(c, d);
        long lcm = c/e*d;
        long a = lcm/b1*a1+lcm/b2*a2;
        long b = lcm;
        c = Math.max(a,b);
        d = Math.min(a,b);
        e = gcd(c,d);
        System.out.println(a/e+" "+b/e);
    }

    private static long gcd(long c, long d) {
        if(d == 0) return c;
        return gcd(d, c%d);
    }
}
