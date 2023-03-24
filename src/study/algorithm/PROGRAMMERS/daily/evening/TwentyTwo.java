package study.algorithm.PROGRAMMERS.daily.evening;

public class TwentyTwo {
    public int solution(int n) {
        int answer = 1;
        if(n ==0) return 0;
        int fact = 1;
        while(fact<=n){
            fact *= answer;
            answer++;
        }
        return answer-2;
    }
}
