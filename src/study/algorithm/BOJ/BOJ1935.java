package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BOJ1935 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char [] cArr =  br.readLine().toCharArray();
        double[] arr = new double[N];
        for(int i=0;i<N;i++){
            arr[i] = Double.parseDouble(br.readLine());
        }
        Stack<Double> stack = new Stack<>();
        for(char c : cArr){
            if(Character.isAlphabetic(c))
                stack.push(arr[c-'A']);
            else{
                double secondnum = stack.pop();
                double firstnum = stack.pop();
                double total = 0L;
                switch(c){
                    case '+' :
                        total = firstnum + secondnum;
                        break;
                    case '-' :
                        total = firstnum - secondnum;
                        break;
                    case '/' :
                        total = firstnum / secondnum;
                        break;
                    case '*' :
                        total = firstnum*secondnum;
                        break;
                 }
                 stack.push(total);
            }
        }
        System.out.printf("%.2f\n",stack.pop());
    }
}
