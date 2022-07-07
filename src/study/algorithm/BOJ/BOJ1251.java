package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ1251 {

    public String s;
    public String min = "";
    public void dfs(int n, int start, Deque<Integer> deque){
        if(n == 0) {
            int secondStart=-1;
            int thirdStart=-1;
            for(int i : deque){
                if(secondStart == -1)
                    secondStart = i;
                else
                    thirdStart = i;
            }
            StringBuilder sb = new StringBuilder();
            String first = s.substring(0,secondStart);
            String second = s.substring(secondStart,thirdStart);
            String third = s.substring(thirdStart);
            sb.append(reverse(first));
            sb.append(reverse(second));
            sb.append(reverse(third));
            if(min.isEmpty()){
                min = sb.toString();
            }
            else{
                String tempNum = sb.toString();
                min = min.compareTo(tempNum) <=0 ? min : tempNum;
            }
            return;
        }
        for(int i=start+1;i<s.length();i++){
            deque.add(i);
            dfs(n-1,i,deque);
            deque.pollLast();
        }
    }
    public String reverse(String s){
        StringBuilder sb= new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        dfs(2,0, new LinkedList<>());
        System.out.println(min);
    }

}
