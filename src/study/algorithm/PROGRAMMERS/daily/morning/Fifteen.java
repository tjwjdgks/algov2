package study.algorithm.PROGRAMMERS.daily.morning;

import java.util.HashMap;
import java.util.Map;

public class Fifteen {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                answer[index] = index - map.get(c);
            }
            else{
                answer[index] = -1;
            }
            map.put(c,index);
            index++;
        }
        return answer;
    }
}
