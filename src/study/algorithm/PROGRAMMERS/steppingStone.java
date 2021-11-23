package study.algorithm.PROGRAMMERS;

import java.util.Arrays;

// 코드 디버깅 확실히 할 것
public class steppingStone {
    public int solution(int distance, int[] rocks, int n) {
        int left = 1;
        Arrays.sort(rocks);
        int right = distance;
        while(left<right){
            int mid = (left+right)/2;
            if(isPossible(rocks,distance,n,mid)){
                left = mid+1;
            }
            else right = mid;
        }
        return left-1;
        /*
        while(left<=right){
            int mid  = (left+right)/2;
            if(isPossible(rocks,distance,n,mid)){
                left = mid+1;
            }
            else right = mid-1;
        }
        return right;

         */
    }
    public boolean isPossible(int[] rocks, int distance, int n, int tempdist){
        int totalRemoveRock = 0;
        int curdist = 0;
        for(int i=0;i<rocks.length;i++){
            if(totalRemoveRock>n){
                return false;
            }
            if(rocks[i]-curdist<tempdist){
                totalRemoveRock++;
            }
            else
                curdist = rocks[i];

        }
        if(distance-curdist<tempdist)
            totalRemoveRock++;
        if(totalRemoveRock>n) return false;
        return true;
    }
}
