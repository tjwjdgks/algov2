package study.algorithm.PROGRAMMERS.basic;
import java.util.*;
public class NextBigNumber {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        Deque<Integer> deque = new LinkedList<>();
        for(int i=len-1; i>=0; i--){
            while(!deque.isEmpty()){
                int backwardNum = deque.pollFirst();
                if(numbers[i] < backwardNum) {
                    deque.addFirst(backwardNum);
                    deque.addFirst(numbers[i]);
                    answer[i] = backwardNum;
                    break;
                }
            }
            if(deque.isEmpty()){
                answer[i] = -1;
                deque.addFirst(numbers[i]);
            }

        }
        return answer;
    }
}
