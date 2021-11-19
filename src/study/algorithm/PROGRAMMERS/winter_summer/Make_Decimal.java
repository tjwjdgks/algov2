package study.algorithm.PROGRAMMERS.winter_summer;

public class Make_Decimal {
    public boolean isDecimal(int answer){
        if(answer == 2) return true;
        for(int i=2;i<=Math.sqrt(answer);i++){
            if(answer%i==0) return false;
        }
        return true;
    }
    public int solution(int[] nums){
        int answer =0;
        int length = nums.length;
        for(int i=0;i<length-2;i++){
            for(int j=i+1;j<length-1;j++){
                for(int k=j+1;k<length;k++){
                    if(isDecimal(nums[i]+nums[j]+nums[k]))
                        answer++;
                }
            }
        }
        return answer;
    }
}
