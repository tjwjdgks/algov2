package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5073 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        while(true){
            int [] s = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
            if(s[0] == 0) break;
            Arrays.sort(s);
            if(s[0] + s[1] <= s[2]){
               sb.append("Invalid");
            }
            else if(s[0] == s[1] && s[0] == s[2]){
                sb.append("Equilateral");
            }
            else if(s[0] != s[1] && s[0] != s[2] && s[1] != s[2]){
                sb.append("Scalene");
            }
            else{
                sb.append("Isosceles");
            }
            sb.append("\n");

        }
        System.out.println(sb.toString());
    }
}
