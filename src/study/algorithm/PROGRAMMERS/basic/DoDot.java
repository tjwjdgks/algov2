package study.algorithm.PROGRAMMERS.basic;

public class DoDot {
    public long solution(int k, int d) {
        long answer = 0;
        if(k > d ) return 1;
        for(int i=0; i<=d; i++) {
            if(i%k != 0) continue;
            answer += (int)Math.sqrt((long)d*d - (long)i*i)/k +1;
        }
        return answer;
    }
}
