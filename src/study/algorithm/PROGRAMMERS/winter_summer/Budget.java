package study.algorithm.PROGRAMMERS.winter_summer;

import java.util.Arrays;

public class Budget {
    public int solution(int [] d, int budget){
        Arrays.sort(d);
        int answer  =0;
        for (int j : d) {
            if (budget < j) break;
            answer++;
            budget -= j;
        }
        return answer;
    }
}
