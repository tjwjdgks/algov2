package study.algorithm.PROGRAMMERS.daily.evening;

import java.util.Map;
import java.util.TreeMap;

public class Eighteen {
    public String solution(String s) {
        Map<Character,Integer> map = new TreeMap();
        for(char a : s.toCharArray()){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        String answer = "";
        for(char c : map.keySet()){
            if(map.get(c) == 1){
                answer += c;
            }
        }
        return answer;
    }
}
