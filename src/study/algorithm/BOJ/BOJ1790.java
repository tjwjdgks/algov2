package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1790 {
    public static void getAnswer() throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long charLength = 1;
        long digitCount = 9;
        while(true){
            if(K < charLength * digitCount){
                break;
            }
            K -= charLength * digitCount;
            charLength++;
            digitCount= digitCount*10;
        }
        long gap = K/charLength ;
        long rest = K%charLength;
        if(rest != 0) gap++;
        long num = (long)Math.pow(10,charLength-1) + gap -1;
        if(num<=N){
            String num_s = Long.toString(num);
            if(rest == 0) {
                System.out.println(num_s.charAt(num_s.length()-1));
            }
            else {
                System.out.println(num_s.charAt((int)rest-1));
            }
        }
        else System.out.println(-1);
    }
}
