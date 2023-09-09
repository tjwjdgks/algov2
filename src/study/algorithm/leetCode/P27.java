package study.algorithm.leetCode;


import java.util.*;

public class P27 {
    public int removeElement(int[] nums, int val) {
        int total = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == val){
                nums[i] = Integer.MAX_VALUE;
            }
            else total +=1;
        }
        Arrays.sort(nums);
        return total;
    }
}
