package study.algorithm.PROGRAMMERS.basic;

import java.util.ArrayList;
import java.util.List;

public class Upark {
    public double[] solution(int k, int[][] ranges) {
        List<Double> area = new ArrayList<>();
        double total = 0;
        area.add(total);
        while(k!=1){
            int pre = k;
            if(k%2 ==0) {
                k = k/2;
            }
            else {
                k = k*3 +1;
            }
            double curArea = (double) (pre + k) /2;
            total += curArea;
            area.add(total);
        }
        int n = area.size()-1;
        double[] answer = new double[ranges.length];
        for(int i=0; i<ranges.length; i++) {
            int areaEnd = n + ranges[i][1];
            int areaStart = ranges[i][0];
            if(areaEnd < areaStart) answer[i] = -1;
            else answer[i] = area.get(areaEnd) - area.get(areaStart);
        }
        return answer;
    }
}
