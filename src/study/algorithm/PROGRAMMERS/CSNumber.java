package study.algorithm.PROGRAMMERS;

import java.util.*;

public class CSNumber {

    public int solution(int k, int n, int[][] reqs) {
        List[] table = new List[k];
        initTable(table, reqs);
        int restN = n-k;
        int[] indexTable = new int[k];
        Arrays.fill(indexTable, 1);
        while(restN!=0){
            int maxIndex = 0;
            int maxTotal = 0;
            for(int i=0;i<k;i++){
                int getCurTotal = getTotal(table[i], indexTable[i]) - getTotal(table[i], indexTable[i]+1);
                if(getCurTotal > maxTotal){
                    maxTotal = getCurTotal;
                    maxIndex = i;
                }
            }
            indexTable[maxIndex]++;
            restN--;
        }
        int answer=0;
        for(int i=0;i<k;i++){
            answer += getTotal(table[i], indexTable[i]);
        }
        return answer;
    }
    public int getTotal(List<int[]> lists, int step){
        Queue<Integer> pq = new PriorityQueue<>();
        int waitTime = 0;
        for(int[] list : lists){
            int startTime = list[0];
            int duration = list[1];
            if(pq.size() < step){
                pq.add(startTime + duration);
            }
            else{
                int minFinishTime = pq.poll();
                if(startTime >= minFinishTime){
                    pq.add(startTime + duration);
                }
                else{
                    waitTime += minFinishTime - startTime;
                    pq.add(minFinishTime+ duration);
                }
            }
        }
        return waitTime;
    }
    public void initTable(List[] table, int[][] reqs){
        for(int i=0;i<table.length;i++){
            table[i] = new ArrayList<int[]>();
        }
        for(int [] req : reqs){
            table[req[2]-1].add(new int[]{req[0], req[1]});
        }
    }
}
