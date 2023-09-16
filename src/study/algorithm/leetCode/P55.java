package study.algorithm.leetCode;

public class P55 {
    public boolean canJump(int[] nums) {
        int maxNum = nums[0];
        for(int i=0;i<nums.length;i++){
            if(maxNum >=i){
                maxNum = Math.max(maxNum, i+nums[i]);
            }
            else break;
        }

        if(maxNum >= nums.length-1){
            return true;
        }
        return false;
    }
}