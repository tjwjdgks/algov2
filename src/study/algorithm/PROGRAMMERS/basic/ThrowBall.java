package study.algorithm.PROGRAMMERS.basic;

public class ThrowBall {
    public int solution(int[] numbers, int k) {
        int answer = numbers[2*(k-1)%numbers.length];
        return answer;
    }
}
