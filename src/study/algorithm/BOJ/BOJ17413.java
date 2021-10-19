package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17413 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for(char c : s.toCharArray()){
            if(c == ' '){
               if(flag){
                   while(!stack.isEmpty())
                       sb.append(stack.pop());
               }
               sb.append(c);
            }
            else if(c == '<'){
                if(!stack.isEmpty()){
                    while(!stack.isEmpty())
                        sb.append(stack.pop());
                }
                flag = false;
                sb.append(c);
            }
            else if(c == '>'){
                flag = true;
                sb.append(c);
            }
            else{
                if(flag){
                    stack.push(c);
                }
                else sb.append(c);
            }
        }
        while(!stack.isEmpty())
            sb.append(stack.pop());
        System.out.println(sb.toString());
    }
}
