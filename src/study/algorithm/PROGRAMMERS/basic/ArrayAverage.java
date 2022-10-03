package study.algorithm.PROGRAMMERS.basic;

import java.util.Arrays;

public class ArrayAverage {

    public double solution(int[] numbers) {
        double answer = Arrays.stream(numbers).average().orElse(0);
        return answer;
    }

}
