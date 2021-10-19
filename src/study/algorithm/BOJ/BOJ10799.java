package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10799 {
    public static void getAnswer()throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer =0;
        for(int i=0;i<s.length();i++){
           char tempc = s.charAt(i);
           if(tempc == '('){
               stack.push(tempc);
           }
           else{
               stack.pop();
               if(s.charAt(i-1) == '(')
                   answer += stack.size();
               else
                   answer +=1;
           }
        }
        System.out.println(answer);
    }
}
