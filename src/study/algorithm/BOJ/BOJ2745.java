package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2745 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String target =  st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int total = 0;
        int idx = 1;
        for(int i=target.length()-1;i>=0;i--){
            if(Character.isUpperCase(target.charAt(i))){
                total += idx*(target.charAt(i)-'A'+10);
            }
            else{
                total += idx*(target.charAt(i)-'0');
            }
            idx*=B;
        }
        System.out.println(total);
    }
}
