package study.algorithm.leetCode;

import java.util.*;
public class P122 {
    public int maxProfit(int[] prices) {
        int maxNum = prices[0];
        int minNum = prices[0];
        int answer =0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] < prices[i-1]){
                answer += maxNum - minNum;
                minNum = prices[i];
                maxNum = prices[i];
            }
            if(maxNum < prices[i]){
                maxNum = prices[i];
            }
        }
        answer += maxNum - minNum;
        return answer;
    }
}
