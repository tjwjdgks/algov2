package study.algorithm.leetCode;

public class P977 {
    public int[] sortedSquares(int[] nums) {
        int[] new_nums = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        int count = nums.length-1;
        while(left<=right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                new_nums[count--] = nums[left]*nums[left];
                left++;
            }
            else{
                new_nums[count--] = nums[right]*nums[right];
                right--;
            }
        }
        return new_nums;
    }
}
