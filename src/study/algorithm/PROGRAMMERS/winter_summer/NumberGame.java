package study.algorithm.PROGRAMMERS.winter_summer;

import java.util.*;

public class NumberGame {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        Deque<Integer> queue_A = new ArrayDeque<>();
        Deque<Integer> queue_B = new ArrayDeque<>();
        for(int i: A)
            queue_A.add(i);
        for(int i:B)
            queue_B.add(i);
        while(!queue_A.isEmpty()){
            int max_val_A = queue_A.getLast();
            int max_val_B = queue_B.getLast();
            if(max_val_B>max_val_A){
                answer++;
                queue_A.removeLast();
                queue_B.removeLast();
            }
            else{
                queue_B.removeFirst();
                queue_A.removeLast();
            }
        }
        return answer;
    }
}
