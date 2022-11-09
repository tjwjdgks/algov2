package study.algorithm.PROGRAMMERS.daily.morning;

public class Six {
    public int solution(int[] common) {
        int answer = 0;
        int firstNum = common[0];
        int secondNum = common[1];
        int thirdNum = common[2];
        if((secondNum - firstNum) == (thirdNum - secondNum)){
            answer = common[common.length-1] + (secondNum - firstNum);
        }
        else{
            answer = common[common.length-1] * (secondNum/firstNum);
        }
        return answer;
    }

}
