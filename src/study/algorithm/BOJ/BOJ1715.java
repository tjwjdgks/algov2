package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ1715 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            pq.add(Long.parseLong(br.readLine()));
        }
        long answer = 0;
        while(pq.size()!=1){
            long first = pq.poll();
            long second = pq.poll();
            pq.add(first+second);
            answer += first+second;
        }
        System.out.println(answer);
    }
}
