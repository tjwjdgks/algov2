package study.algorithm.PROGRAMMERS.daily.morning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class fourteen {

    private List<Integer> divisors;

    private void findDivisors(int num) {

        divisors = new ArrayList<>();

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                divisors.add(i);
                divisors.add(num / i);
            }
        }

        divisors.add(num);
    }

    boolean canDivideAllElement(int divisor, int[] arr) {
        for (int num : arr)
            if (num % divisor != 0)
                return false;
        return true;
    }

    boolean cantDivideAllElement(int divisor, int[] arr) {
        for (int num : arr)
            if (num % divisor == 0)
                return false;
        return true;
    }

    private int findNumSatisfyConditions(int[] divArr, int[] nonDivArr) {

        Arrays.sort(divArr);
        findDivisors(divArr[0]);

        Collections.sort(divisors, Collections.reverseOrder());

        for (int divisor : divisors) {
            if (canDivideAllElement(divisor, divArr) == true
                    && cantDivideAllElement(divisor, nonDivArr) == true)
                return divisor;
        }
        divisors.clear();
        return 0;
    }

    public int solution(int[] arrayA, int[] arrayB) {

        int answer = 0;
        int satisfyingNum;

        satisfyingNum = findNumSatisfyConditions(arrayA, arrayB);
        answer = (satisfyingNum > answer) ? satisfyingNum : answer;

        satisfyingNum = findNumSatisfyConditions(arrayB, arrayA);
        answer = (satisfyingNum > answer) ? satisfyingNum : answer;

        return answer;
    }
}