package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] s = new String[5];
        int maxLength = -1;
        for(int i=0; i<5;i++){
            s[i] = br.readLine();
            maxLength = Math.max(maxLength, s[i].length());
        }
        String answer = "";
        for(int i=0;i<maxLength;i++){
            for(int j=0;j<5;j++){
                if(s[j].length()>i){
                    answer += s[j].charAt(i);
                }
            }
        }
        System.out.println(answer);
    }
}
