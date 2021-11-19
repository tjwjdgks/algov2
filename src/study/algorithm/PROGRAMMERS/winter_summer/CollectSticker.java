package study.algorithm.PROGRAMMERS.winter_summer;

public class CollectSticker {
    public int solution(int sticker[]) {
        int len = sticker.length;
        if(len == 1)
            return sticker[0];
        if(len == 2)
            return Math.max(sticker[0],sticker[1]);
        return Math.max(getMaxTotal(0,len-1,sticker),getMaxTotal(1,len,sticker));
    }
    public int getMaxTotal(int from, int to, int[] arr){
        int [] dp = new int[arr.length-1];
        dp[0] = arr[from];
        dp[1] = Math.max(arr[from+1],arr[to-1]);
        for(int i=2,st=from+2;i<dp.length&&st<to;i++,st++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+arr[st]);
        }
        return dp[dp.length-1];
    }
}
