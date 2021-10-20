package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2089 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        if(N==0){
            System.out.println(N);
            return;
        }
        while(N!=1){
            sb.append(Math.abs(N%-2));
            N = (int)Math.ceil((double)N/-2);
        }
        sb.append(N);
        System.out.println(sb.reverse());
    }
}
