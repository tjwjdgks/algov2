package study.algorithm.PROGRAMMERS;

public class BetweenCircle {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(int i=-r2; i<=r2;i++){
            for(int j=-r2;j<=r2;j++){
                int total = i*i + j*j;
                if(total >= r1*r1 && total <=r2*r2){
                    answer++;
                }
            }
        }
        return answer;
    }
}
