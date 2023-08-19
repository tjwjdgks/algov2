package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25501 {

    static int callCount = 0;
    static int recursion(String s, int start, int end){
        callCount++;
        if(start >= end) return 1;
        else if(s.charAt(start) != s.charAt(end)) return 0;
        return recursion(s, start+1, end-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            String s = br.readLine();
            callCount = 0;
            sb.append(recursion(s, 0, s.length()-1)).append(" ").append(callCount).append("\n");
        }
        System.out.println(sb.toString());
    }
}
