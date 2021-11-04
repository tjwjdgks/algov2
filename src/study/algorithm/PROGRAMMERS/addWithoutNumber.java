package study.algorithm.PROGRAMMERS;

public class addWithoutNumber {
    public int solution(int[] numbers) {
        int answer = 55;
        for(int i : numbers)
            answer -= i;
        return answer;
    }
}
