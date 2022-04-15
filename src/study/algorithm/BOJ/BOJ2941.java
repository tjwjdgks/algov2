package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2941 {
    public static char[] cArr;
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String s2 = s.replaceAll("(c=)|(c-)|(dz=)|(d-)|(lj)|(nj)|(s=)|(z=)", " ");
        System.out.println(s2.length());
    }
}
