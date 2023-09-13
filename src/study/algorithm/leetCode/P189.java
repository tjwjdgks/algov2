package study.algorithm.leetCode;

import java.util.*;

public class P189 {
    public void rotate(int[] nums, int k) {
        int rotateNum = k % nums.length;
        int [] new_nums = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int index = (i+rotateNum)%nums.length;
            new_nums[index] = nums[i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = new_nums[i];
        }
    }
}