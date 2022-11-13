package study.algorithm.PROGRAMMERS.daily.evening;

import java.util.HashMap;
import java.util.Map;

public class Nine {
    public int solution(int[] array) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : array){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int maxNum = -1;
        int maxCount = 0;
        boolean flag = false;
        for(int key : map.keySet()){
            int curVal = map.get(key);
            if(curVal ==  maxCount){
                flag = true;
            }
            else if(curVal > maxCount){
                flag = false;
                maxCount = curVal;
                maxNum = key;
            }
        }
        if(flag) return -1;
        return maxNum;
    }

}
