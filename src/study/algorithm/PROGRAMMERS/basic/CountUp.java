package study.algorithm.PROGRAMMERS.basic;

import java.util.stream.IntStream;

public class CountUp {
    public int[] solution(int start_num, int end_num) {
        int[] answer = IntStream.range(start_num,end_num+1).toArray();
        return answer;
    }
}
