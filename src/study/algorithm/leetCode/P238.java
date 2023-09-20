package study.algorithm.leetCode;


public class P238 {
    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int zeroCount = 0;
        for(int i : nums){
            if(i == 0){
                zeroCount +=1;
            }
            else total *=i;
        }
        int [] answer = new int[nums.length];
        if(zeroCount == 0){
            for(int i=0;i<nums.length;i++){
                answer[i] = total/nums[i];
            }
        }
        else if(zeroCount == 1){
            for(int i=0;i<nums.length;i++){
                if(nums[i] == 0) answer[i] = total;
            }
        }

        return answer;
    }
}
