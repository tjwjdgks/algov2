package study.algorithm.PROGRAMMERS.daily.morning;

public class Eight {
    public int solution(int n) {
        int answer = 0;
        int curNum = n;
        if(n%2 != 0 ){
            curNum *=2;
        }
        if(n%3 != 0){
            curNum *=3;
        }
        answer = curNum/6;
        return answer;
    }

}
