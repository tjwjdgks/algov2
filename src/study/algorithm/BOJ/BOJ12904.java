package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ12904 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String startS = br.readLine();
        String endS =  br.readLine();
        LinkedList<Character> queue = new LinkedList<>();
        for(char c : endS.toCharArray()) {
            queue.add(c);
        }

        while(queue.size() != startS.length()){
            char c = queue.pollLast();
            if(c == 'B'){
                Collections.reverse(queue);
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!queue.isEmpty()){
            sb.append(queue.pollFirst());
        }
        if(startS.equals(sb.toString())){
            System.out.println(1);
        }
        else System.out.println(0);

    }
}
