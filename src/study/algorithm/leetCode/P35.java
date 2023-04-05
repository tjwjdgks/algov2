package study.algorithm.leetCode;

public class P35 {
    public int searchInsert(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;
        int mid = 0;
        while(begin < end){
            mid = begin + (end-begin)/2;
            if(nums[mid]<target){
                begin = mid+1;
            }
            else{
                end = mid;
            }
        }
        return begin;
    }
}
