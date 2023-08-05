package study.algorithm.study.dk.week26;

import java.util.PriorityQueue;
import java.util.Queue;

public class Henry {
    public int solution(int[] A, int[] B) {
        Queue<Integer> pqA = new PriorityQueue<>();
        Queue<Integer> pqB = new PriorityQueue<>();
        for(int i : A){
            pqA.add(i);
        }
        for(int i : B){
            pqB.add(i);
        }
        int answer = 0;
        while(!pqA.isEmpty() && !pqB.isEmpty()){
            int a = pqA.poll();
            while(!pqB.isEmpty()){
                int b = pqB.poll();
                if(a<b){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
