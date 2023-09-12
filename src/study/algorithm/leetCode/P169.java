package study.algorithm.leetCode;


import java.util.*;
public class P169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        int maxCount = 0;
        int answer = -1;
        for(int i : map.keySet()){
            if(maxCount < map.get(i)){
                maxCount = map.get(i);
                answer = i;
            }
        }
        return answer;
    }
}
