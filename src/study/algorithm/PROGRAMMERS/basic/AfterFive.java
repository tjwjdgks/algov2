package study.algorithm.PROGRAMMERS.basic;

import java.util.Arrays;

public class AfterFive {
    public int[] solution(int[] num_list) {
        int[] answer = Arrays.stream(num_list).sorted().skip(5).toArray();
        return answer;
    }
}
