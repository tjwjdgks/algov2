package study.algorithm.PROGRAMMERS.basic;

import java.util.Arrays;

public class SplitArray {
    public int[] solution(int[] numbers, int num1, int num2) {

        int [] answer = Arrays.copyOfRange(numbers,num1,num2+1);
        return answer;
    }

}
