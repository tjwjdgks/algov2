package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ11576 {
    public static int StringArrToIntNotation(String[] s, int stand){
        int count = 1;
        int total = 0;
        for(int i=s.length-1;i>=0;i--){
            int n = Integer.parseInt(s[i]);
            total += n*count;
            count *= stand;
        }
        return total;
    }
    public static String IntToStringNotation(int num, int stand){
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        while(num!=0){
            stack.push(num%stand);
            num /=stand;
        }
        while(!stack.isEmpty())
            sb.append(stack.pop()).append(" ");
        return sb.toString();
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int target = StringArrToIntNotation(arr,A);
        String changedNum = IntToStringNotation(target,B);
        System.out.println(changedNum);
    }
}
