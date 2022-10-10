package study.algorithm.PROGRAMMERS.basic;

import java.util.Arrays;

public class SortString {
    public String solution(String my_string) {
        String answer = my_string.toLowerCase();
        char [] cArr = answer.toCharArray();
        Arrays.sort(cArr);
        answer = new String(cArr);
        return answer;
    }

}
