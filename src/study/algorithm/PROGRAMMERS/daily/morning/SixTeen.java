package study.algorithm.PROGRAMMERS.daily.morning;

import java.util.Arrays;

public class SixTeen {
    public int solution(int[] num_list, int n) {
        return Arrays.stream(num_list).anyMatch(i->i==n) ? 1 : 0;

    }
}
