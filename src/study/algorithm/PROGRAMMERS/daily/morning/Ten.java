package study.algorithm.PROGRAMMERS.daily.morning;

import java.util.PriorityQueue;
import java.util.Queue;

public class Ten {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        Queue<Integer> pq = new PriorityQueue<Integer>((o1,o2)->{
            return o1-o2;
        });

        int i = 0;
        k = k < score.length ? k : score.length;
        for(;i<k;i++){
            pq.add(score[i]);
            answer[i] = pq.peek();
        }
        for(;i<score.length;i++){
            pq.add(score[i]);
            pq.poll();
            answer[i] = pq.peek();
        }

        return answer;
    }

}
