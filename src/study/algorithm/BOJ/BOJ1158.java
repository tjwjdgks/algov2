package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BOJ1158 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K =  Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();
        sb.append("<");
        Queue<Integer> queue = IntStream.range(1,N+1).boxed().collect(Collectors.toCollection(LinkedList::new));
        while(!queue.isEmpty()){
            if(queue.size() == 1){
                sb.append(queue.poll()).append(">");
            }
            else{
                int count =1;
                while(count<K){
                    queue.add(queue.poll());
                    count++;
                }
                int target = queue.poll();
                sb.append(target).append(", ");
            }
        }
        System.out.println(sb.toString());
    }
}
