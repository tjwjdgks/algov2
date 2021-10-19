package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11655 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cArr = br.readLine().toCharArray();
        for(int i=0;i<cArr.length;i++){
            if(Character.isUpperCase(cArr[i])){
                if(cArr[i]+13>'Z'){
                    cArr[i] = (char)(((cArr[i]+13)-'Z'+-1)+'A');
                }
                else
                    cArr[i] += 13;
            }
            else if(Character.isLowerCase(cArr[i])){
                if(cArr[i]+13>'z'){
                    cArr[i] = (char)(((cArr[i]+13)-'z'+-1)+'a');
                }
                else
                    cArr[i] += 13;
            }
        }
        System.out.println(new String(cArr));
    }
}
