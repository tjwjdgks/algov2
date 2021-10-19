package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BOJ17299 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        int [] answerArr = new int[N];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=N-1;i>=0;i--){
            if(i == N-1){
                answerArr[i] = -1;
                stack.push(arr[i]);
            }
            else{
                int curcount = map.get(arr[i]);
                while(!stack.isEmpty()){
                    int tempcount = map.get(stack.peek());
                    if(curcount>=tempcount)
                        stack.pop();
                    else{
                        answerArr[i] = stack.peek();
                        break;
                    }
                }
                if(stack.isEmpty())
                    answerArr[i] = -1;
                stack.push(arr[i]);
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i: answerArr)
            sb.append(i).append(" ");
        System.out.println(sb.toString());
    }
}
