package study.algorithm.PROGRAMMERS.basic;

public class MagicElevator {
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0) {
            int rest = storey%10;
            if(rest < 5) {
                answer += rest;
                storey = storey/10;
            }
            else if(rest > 5){
                answer += 10 - rest;
                storey = storey/10+1;
            }
            else {
                storey = storey/10;
                answer += 10 - rest;
                if((storey%10) >= 5) {
                    storey += 1;
                }
            }
        }
        return answer;
    }
}
