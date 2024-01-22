package study.algorithm.PROGRAMMERS.basic;

public class Bondage {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int timeCount = 0;
        int lastTime = attacks[attacks.length-1][0];
        int [] num = new int[lastTime+1];
        num[0] = health;
        for(int i[] : attacks){
            num[i[0]] -= i[1];
        }
        for(int i=1; i<num.length;i++){
            if(num[i] == 0){
                timeCount += 1;
                num[i] = Math.min(num[i-1] + bandage[1], health);
                if(timeCount == bandage[0]){
                    timeCount = 0;
                    num[i] = Math.min(num[i] + bandage[2], health);
                }
            }
            else{
                timeCount = 0;
                num[i] = num[i] + num[i-1];
            }
            if(num[i] <= 0) return -1;

        }
        answer = num[num.length-1];
        return answer;
    }
}
