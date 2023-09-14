package study.algorithm.leetCode;


import java.util.*;

public class P121 {
    public int maxProfit(int[] prices) {
        int maxNum = prices[0];
        int minNum = prices[0];
        int maxGap = 0;
        for(int i=1;i<prices.length;i++){
            if(minNum > prices[i]){
                maxGap = Math.max(maxGap, maxNum - minNum);
                minNum = prices[i];
                maxNum = prices[i];
            }
            if(maxNum < prices[i]){
                maxNum = prices[i];
            }
        }
        maxGap = Math.max(maxGap, maxNum - minNum);
        return maxGap;
    }
}