package study.algorithm.PROGRAMMERS.basic;

import java.util.ArrayList;
import java.util.List;

public class Upark {
    public double[] solution(int k, int[][] ranges) {
        List<Double> area = new ArrayList<>();
        double total = 0;
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
        int n = area.size();
        for(int [] range : ranges) {
            int areaEnd = n - range[1];
            int areaStart = range[0];

        }
        return null;
    }
}
