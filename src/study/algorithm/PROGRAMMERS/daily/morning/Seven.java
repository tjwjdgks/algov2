package study.algorithm.PROGRAMMERS.daily.morning;

import java.util.Arrays;

public class Seven {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        for(int i=score.length-1;i>=0;){
            if(i<m-1) break;
            int minNum = Integer.MAX_VALUE;
            for(int j = i; j>i-m;j--){
                minNum = Math.min(minNum, score[j]);
            }
            answer += minNum*m;
            i -= m;
        }

        return answer;
    }

}
