package study.algorithm.PROGRAMMERS.basic;

import java.util.Arrays;

public class BiggerPeople {

    public int solution(int[] array, int height) {
        long answer = Arrays.stream(array).filter(k -> k > height).count();
        return (int) answer;
    }

}
