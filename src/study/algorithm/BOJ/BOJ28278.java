package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++){
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
            switch(array[0]){
                case 1:
                    stack.push(array[1]);
                    break;
                case 2:
                    if(stack.isEmpty()) sb.append(-1);
                    else sb.append(stack.pop());
                    sb.append("\n");
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
                    break;
                case 4:
                    if(stack.isEmpty()) sb.append(1);
                    else sb.append(0);
                    sb.append("\n");
                    break;
                case 5:
                    if(stack.isEmpty()) sb.append(-1);
                    else sb.append(stack.peek());
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
