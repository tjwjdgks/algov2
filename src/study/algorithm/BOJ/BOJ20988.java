package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ20988 {

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int start = 0;
        int end = s.length()-1;
        boolean flag = true;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                flag = false;
                break;
            }
            start++;
            end--;
        }
        if(flag) System.out.println("1");
        else System.out.println("0");
    }
}
