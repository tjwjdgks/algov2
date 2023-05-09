package study.algorithm.study.dk.week14;

import java.util.PriorityQueue;
import java.util.Queue;

public class June {
    // picks 0 - 다이아몬드 1 - iron 2 - stone
    public int[][] pick = new int[][]{
            {1,1,1},
            {5,1,1},
            {25,5,1}
    };
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int count = 0;
        Queue<int[]> queue = new PriorityQueue<>((o1,o2)->{
            if(o2[0] == o2[0]){
                if(o2[1] == o1[1]){
                    return o2[2] - o1[2];
                }
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });
        int maxLength = 0;
        for(int i=0;i<picks.length;i++){
            maxLength += 5*picks[i];
        }
        maxLength = Math.min(maxLength,minerals.length);
        while(count < maxLength){
            int length = Math.min(count + 5, maxLength);
            int dia = 0;
            int iron = 0;
            int stone = 0;
            int weight = 0;
            for(int i=count; i<length;i++){
                switch(minerals[i]){
                    case "diamond" :
                        dia  += 1;
                        weight += 25;
                        break;
                    case "iron" :
                        iron +=  1;
                        weight += 5;
                        break;
                    case "stone":
                        stone += 1;
                        weight += 1;
                        break;
                }
            }
            queue.add(new int[]{weight,dia,iron,stone});
            count = length;
        }
        while(!queue.isEmpty()){
            int [] curIndex = queue.poll();
            int curPickerIndex = -1;
            for(int i=0;i<picks.length;i++){
                if(picks[i] !=0){
                    picks[i] -=1;
                    curPickerIndex = i;
                    break;
                }
            }
            if(curPickerIndex == -1) continue;
            for(int i=1;i<=3;i++){
                answer += pick[curPickerIndex][i-1] * curIndex[i];
            }
        }
        return answer;
    }
    public static void main(String [] args){
        June j = new June();
        j.solution(new int[]{0, 1, 1},new String[]{"iron", "iron", "iron", "iron", "iron", "diamond"});

    }
}
