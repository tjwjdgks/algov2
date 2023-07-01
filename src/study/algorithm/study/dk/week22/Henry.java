package study.algorithm.study.dk.week22;

import java.util.ArrayList;
import java.util.List;

public class Henry {
    public int cal(int div, int start, int end){
        int total = 0;
        int dist = end-start+1;
        total += dist/div;
        if(dist%div!=0) total+=1;
        return total;
    }
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();
        int pre = 1;
        int div = w*2+1;
        for(int i=0;i<stations.length;i++){
            int start = stations[i]-w;
            int end = stations[i]+w;
            if(start>pre){
                answer += cal(div,pre,start-1);
            }
            pre = end+1;
        }
        if(pre<=n)
            answer += cal(div,pre,n);
        return answer;
    }
}
