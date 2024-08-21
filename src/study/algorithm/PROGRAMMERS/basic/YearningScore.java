package study.algorithm.PROGRAMMERS.basic;

import java.util.*;
public class YearningScore {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int [] n = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        for(int i=0; i<photo.length; i++){
            int size = 0;
            for(String s : photo[i]){
                size += map.getOrDefault(s, 0);
            }
            n[i] = size;
        }
        return n;
    }
}
