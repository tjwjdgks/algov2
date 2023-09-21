package study.algorithm.leetCode;


import java.util.*;
public class P134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int [] gap = new int[gas.length];
        for(int i=0;i<gap.length;i++){
            gap[i] = gas[i] - cost[i];
        }
        int maxIndex = 0;
        for(int i=0;i<gap.length;i++){
            int total = 0;
            int j = i;
            for(j=i;j<i+gap.length;j++){
                total += gap[j%gap.length];
                if(total<0) break;
            }
            if(j == i+gap.length) return i;
            i = j;
        }
        return -1;
    }
}
