package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11005 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();

        while(N!=0){
            int rest = N%B;
            if(rest>=10){
                char c = (char)((rest-10)+'A');
                sb.append(c);
            }
            else
                sb.append(rest);
            N /= B;
        }
        System.out.println(sb.reverse());
    }
}
