package study.algorithm.PROGRAMMERS;

import java.util.HashMap;
import java.util.Map;

public class TestPersonalColor {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String [] personalColor = new String[] {"RT","CF","JM","AN"};

        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0; i<survey.length; i++){
            int num = choices[i]-4;
            if(num < 0){
                map.put(survey[i].charAt(0),
                    map.getOrDefault(survey[i].charAt(0),0)+Math.abs(num));
            }
            else{
                map.put(survey[i].charAt(1),
                    map.getOrDefault(survey[i].charAt(1),0)+Math.abs(num));
            }
        }
        for(String s : personalColor){
            char first = s.charAt(0);
            char second = s.charAt(1);
            if(map.getOrDefault(first,0) > map.getOrDefault(second,0)){
                answer += first;
            }
            else if(map.getOrDefault(first,0)<map.getOrDefault(second,0)){
                answer += second;
            }
            else answer += first;
        }

        return answer;
    }
}
