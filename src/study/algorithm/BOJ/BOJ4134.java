package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            long c = Long.parseLong(br.readLine());
            while(true){
                if(isPrime(c)){
                    sb.append(c).append("\n");
                    break;
                }
                c++;
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean isPrime(long c) {
        if(c<2) return false;
        if(c == 2 || c == 3) return true;
        for(int i=2; i<=Math.sqrt(c); i++){
            if(c%i == 0) return false;
        }
        return true;
    }
}
