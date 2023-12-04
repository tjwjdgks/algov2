package study.algorithm.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P205 {
    public boolean isIsomorphic(String s, String t) {
        Set<Character> set = new HashSet<>();
        Map<Character, Character> wordMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char curChar = s.charAt(i);
            if(!wordMap.containsKey(curChar)){
                if(set.contains(t.charAt(i))) return false;
                set.add(t.charAt(i));
                wordMap.put(curChar, t.charAt(i));
            }
            else if(wordMap.get(curChar) != t.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
