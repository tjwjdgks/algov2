package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class BOJ1406 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> leftstack = new Stack<>();
        Stack<Character> rightstack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for(char c : s.toCharArray())
            leftstack.add(c);

        int commandNum = Integer.parseInt(br.readLine());
        for(int i=0; i< commandNum;i++){
            String [] tempArr = br.readLine().split(" ");
            if(tempArr[0].equals("L")){
                if(leftstack.isEmpty()) continue;
                rightstack.push(leftstack.pop());
            }
            else if(tempArr[0].equals("D")){
                if(rightstack.isEmpty()) continue;
                leftstack.push(rightstack.pop());
            }
            else if(tempArr[0].equals("B")){
                if(leftstack.isEmpty()) continue;
                leftstack.pop();
            }
            else{
                leftstack.push(tempArr[1].charAt(0));
            }
        }
        while(!leftstack.isEmpty())
            rightstack.add(leftstack.pop());
        while(!rightstack.isEmpty())
            sb.append(rightstack.pop());

        System.out.println(sb.toString());
    }
}
