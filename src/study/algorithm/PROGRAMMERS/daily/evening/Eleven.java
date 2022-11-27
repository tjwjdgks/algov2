package study.algorithm.PROGRAMMERS.daily.evening;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Eleven {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t,0)+1);
        }

        Queue<Integer> queue = new PriorityQueue<>((o1,o2)->{
            return o2 -o1;
        });

        for(int i : map.keySet()){
            queue.add(map.get(i));
        }

        int count = 0;
        while(!queue.isEmpty()){
            int num = queue.poll();
            count ++;
            if(k<=num){
                break;
            }
            else k-=num;
        }
        return count;
    }
}
