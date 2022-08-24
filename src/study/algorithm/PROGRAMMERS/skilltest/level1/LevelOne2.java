package study.algorithm.PROGRAMMERS.skilltest.level1;


public class LevelOne2 {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long total = 0;
        for(int i=1;i<=count;i++){
            total += i*price;
        }
        answer = total - money;
        if(answer<0) answer =0;
        return answer;
    }
}
