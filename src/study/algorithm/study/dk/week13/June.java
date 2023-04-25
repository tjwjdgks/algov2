package study.algorithm.study.dk.week13;

import java.util.Arrays;

public class June {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(o1, o2)->{
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int start = targets[0][0];
        int end = targets[0][1];
        answer = 1;
        for(int i=1;i<targets.length;i++){
            if(targets[i][0] < end){
                end = Math.min(end, targets[i][1]);
            }
            else{
                start = targets[i][0];
                end = targets[i][1];
                answer++;
            }
        }
        return answer;
    }
}
