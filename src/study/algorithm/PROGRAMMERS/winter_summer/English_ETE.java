package study.algorithm.PROGRAMMERS.winter_summer;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class English_ETE {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> s = new HashSet<>();
        int personidx = -1;
        int time = -1;

        s.add(words[0]);
        if(words[0].length() == 1) return new int[]{0,0};

        for(int i=1;i<words.length;i++){
            if(s.contains(words[i]) ||words[i].length() ==1 || words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                personidx = i%n+1;
                time = i/n+1;
                break;
            }
            s.add(words[i]);
        }
        if(personidx == -1){
            return new int[]{0,0};
        }
        answer[0] = personidx;
        answer[1] = time;
        return answer;
    }
}
