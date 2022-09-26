package study.algorithm.PROGRAMMERS;

import java.util.Arrays;

public class DividedNumArray {

    public int[] solution(int[] arr, int divisor) {
        int[] num = Arrays.stream(arr).filter(i -> i % divisor == 0).sorted().toArray();
        if(num.length == 0) return new int[]{-1};
        else return num;
    }

}
