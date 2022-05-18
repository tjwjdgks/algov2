package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ12919 {
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        Queue<String> queue = new LinkedList<>();
        queue.add(T);
        while(!queue.isEmpty()){
            String curS = queue.poll();
            if(curS.length()<S.length()) continue;
            if(curS.equals(S)){
                System.out.println(1);
                return;
            }
            if(isPossibleC(curS, 'A')){
                queue.add(doC(curS));
            }
            String reverseCurS = new StringBuffer(curS).reverse().toString();
            if(isPossibleC(reverseCurS,'B')){
                queue.add(doC(reverseCurS));
            }
        }
        System.out.println(0);
    }

    private String doC(String curS) {
        return curS.substring(0,curS.length()-1);
    }


    private boolean isPossibleC(String curS, char c) {
        return curS.charAt(curS.length()-1) == c;
    }

}
