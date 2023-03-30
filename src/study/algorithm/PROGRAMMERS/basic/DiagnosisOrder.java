package study.algorithm.PROGRAMMERS.basic;

import java.util.Arrays;

public class DiagnosisOrder {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[][] table = new int[emergency.length][2];
        for(int i=0;i<emergency.length;i++){
            table[i][0] = emergency[i];
            table[i][1] = i;
        }
        Arrays.sort(table,(o1, o2)->{
            return o2[0] - o1[0];
        });
        for(int i=0;i<emergency.length;i++){
            answer[table[i][1]] = i+1;
        }
        return answer;
    }
}
