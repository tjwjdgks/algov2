package study.algorithm.leetCode;


import java.util.*;

public class P80 {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int num = map.getOrDefault(nums[i], 0) +1;
            if(num > 2){
                nums[i] = Integer.MAX_VALUE;
            }
            else{
                count++;
                map.put(nums[i], num);
            }
        }
        Arrays.sort(nums);
        return count;
    }
}
