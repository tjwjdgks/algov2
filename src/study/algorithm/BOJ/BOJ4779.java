package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ4779 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        // br.readLine() 파일 끝일 경우 null
        while((str = br.readLine()) != null){
            int N = Integer.parseInt(str);
            int len = (int)Math.pow(3,N);
            char[] a = new char[len];
            Arrays.fill(a, '-');
            recursive(a, 0, len-1);
            System.out.println(String.valueOf(a));
        }
    }

    private static void recursive(char[] a, int start, int end) {
        if(start == end) return;
        int gap = (end - start + 1)/3;
        recursive(a, start, start+gap-1);
        for(int i=start+gap;i<=start+2*gap-1;i++){
            a[i] = ' ';
        }
        recursive(a, start+ 2*gap, end);
    }
}
