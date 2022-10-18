package study.algorithm.PROGRAMMERS.daily.day2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Two {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int countIdx =0;
        int matchNum = 0;
        int matchTotal = 0;
        Map<String ,Integer > map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        for(int i=0;i<want.length;i++){
            matchTotal += number[i];
            map.put(want[i],number[i]);
        }
        for(int i=0;i<10;i++){
            if(map.containsKey(discount[i])){
                if(map.get(discount[i]) > 0) matchNum++;
                map.put(discount[i],map.get(discount[i])-1);
            }
            countIdx++;
            queue.add(discount[i]);
        }
        while(countIdx<discount.length){
            if(matchNum == matchTotal){
                answer++;
            }
            String key = queue.poll();
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
                if(map.get(key) > 0 ) matchNum--;
            }
            queue.add(discount[countIdx]);
            if(map.containsKey(discount[countIdx])){
                if(map.get(discount[countIdx]) > 0 ) matchNum++;
                map.put(discount[countIdx],map.get(discount[countIdx])-1);
            }
            countIdx++;
        }
        if(matchNum == matchTotal){
            answer++;
        }
        return answer;
    }

}
