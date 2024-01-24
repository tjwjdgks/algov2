package study.algorithm.PROGRAMMERS.basic;

import java.util.Arrays;

public class PracticeMax {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        return Math.max(numbers[0]*numbers[1], numbers[numbers.length-1]*numbers[numbers.length-2]);
    }
}
