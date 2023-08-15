package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int change = Integer.parseInt(br.readLine());
            sb.append(change/25).append(" ");
            change %= 25;
            sb.append(change/10).append(" ");
            change %= 10;
            sb.append(change/5).append(" ");
            change %= 5;
            sb.append(change/1).append("\n");
        }
        System.out.println(sb.toString());
    }
}
