package study.algorithm.leetCode;

public class P278 {
    public int firstBadVersion(int n) {
        int minV = 1;
        int maxV = n;
        while(minV<maxV){
            int mid = minV + (maxV-minV)/2;
            if(isBadVersion(mid)==false){
                minV = mid+1;
            }
            else maxV = mid;
        }
        return minV;
    }

    private boolean isBadVersion(int mid) {
        // 문제에서 제공
        return false;
    }
}
