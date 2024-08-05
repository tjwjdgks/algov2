package study.algorithm.PROGRAMMERS.basic;
import java.util.*;

public class DefenceGame  {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for(int i=0; i<enemy.length;i++){
            if(k > 0) {
                answer += 1;
                queue.add(enemy[i]);
                k--;
            }
            else {
                if(queue.peek() < enemy[i]) {
                    n -= queue.poll();
                    queue.add(enemy[i]);
                }
                else{
                    n -= enemy[i];
                }
                if(n >= 0) answer += 1;
                else break;
            }
        }
        return answer;
    }
}
