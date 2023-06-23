package study.algorithm.PROGRAMMERS;

public class DartCountDown {
    public int[] solution(int target) {
        int[] answer = new int[2];
        int[][] dp = new int[100001][2];
        for(int i=1;i<=target;i++){
            dp[i][0] = Integer.MAX_VALUE/2;
        }
        for(int i=1;i<=20;i++){
            dp[i*3] = new int[]{1,0};
            dp[i*2] = new int[]{1,0};
            dp[i*1] = new int[]{1,1};
        }
        dp[50] = new int[]{1,1};
        for(int i=1;i<=target;i++){
            for(int j=1;j<=20;j++){
                updateDp(dp,i,j*1,true);
                updateDp(dp,i,j*2,false);
                updateDp(dp,i,j*3,false);
            }
            updateDp(dp,i,50,true);
        }
        return dp[target];
    }
    public void updateDp(int[][] dp, int curIndex, int preIndex, boolean addFlag){
        if(curIndex - preIndex < 0) return;
        int preCountPlus = dp[curIndex-preIndex][0]+1;
        int preSingleOrBoolPlus = addFlag ? dp[curIndex-preIndex][1]+1 : dp[curIndex-preIndex][1];
        int curCount = dp[curIndex][0];
        int curSingleOrBool = dp[curIndex][1];
        if(curCount > preCountPlus){
            dp[curIndex][0] = preCountPlus;
            dp[curIndex][1] = preSingleOrBoolPlus;
        }
        else if(curCount == preCountPlus && curSingleOrBool < preSingleOrBoolPlus){
            dp[curIndex][1] = preSingleOrBoolPlus;
        }
    }
}
