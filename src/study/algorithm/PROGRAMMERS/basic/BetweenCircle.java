package study.algorithm.PROGRAMMERS.basic;

public class BetweenCircle {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(int i=1; i<r2; i++){
            long area = (int)Math.sqrt((long)r2*r2 - (long)i*i);
            if(i<=r1){
                area -= (int)Math.sqrt((long)r1*r1 - (long)i*i);
            }
            if(i<r1 && Math.sqrt((long)r1*r1-(long)i*i)%1 ==0) answer+=1L;

            answer += area;
        }
        answer += (r2-r1+1);
        return answer*4;
    }
}
