package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1918 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(Character.isUpperCase(c))
                sb.append(c);
            else{
                switch(c){
                    case '(':
                        stack.push(c);
                        break;
                    case '*':
                    case '/':
                        while(!stack.isEmpty() && (stack.peek()=='*' || stack.peek()=='/')){
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                        break;
                    case '+':
                    case '-':
                        while(!stack.isEmpty() && stack.peek()!='('){
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                        break;
                    case ')':
                        while(!stack.isEmpty() && stack.peek()!='('){
                            sb.append(stack.pop());
                        }
                        stack.pop();
                        break;
                }
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
