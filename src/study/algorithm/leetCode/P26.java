package study.algorithm.leetCode;


import java.util.*;

public class P26 {
    public int removeDuplicates(int[] nums) {
        int total = 1;
        for(int i=nums.length-1; i>=1; i--){
            if(nums[i-1] == nums[i]){
                nums[i] = Integer.MAX_VALUE;
            }
            else total+=1;
        }
        Arrays.sort(nums);
        return total;
    }
}
