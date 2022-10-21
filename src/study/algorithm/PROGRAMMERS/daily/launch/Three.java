package study.algorithm.PROGRAMMERS.daily.launch;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Three {
    public int solution(int[] order) {
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i<=order.length;i++){
            queue.add(i);
        }
        int countIdx = 0;
        int answer = 0;
        while(!queue.isEmpty()){
            if(queue.peek() != order[countIdx]){
                if(!deque.isEmpty() && deque.peekLast() == order[countIdx]){
                    deque.pollLast();
                    countIdx++;
                    answer++;
                }
                else{
                    deque.add(queue.poll());
                }
            }
            else{
                queue.poll();
                countIdx++;
                answer++;
            }
        }
        while(!deque.isEmpty()){
            if(deque.peekLast() == order[countIdx]){
                deque.pollLast();
                answer++;
                countIdx++;
            }
            else break;
        }

        return answer;
    }
}
