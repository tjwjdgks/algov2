package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16968 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int count = 1;
        final int DIGIT = 10;
        final int CHARS = 26;
        // digit 0, chars 1
        int flag= -1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'c'){
                if(flag == 1)
                    count *= CHARS-1;
                else
                    count *= CHARS;
                flag = 1;
            }
            else if(s.charAt(i) == 'd'){
                if(flag == 0)
                    count *= DIGIT-1;
                else
                    count *= DIGIT;
                flag = 0;
            }
        }
        System.out.println(count);
    }
}
