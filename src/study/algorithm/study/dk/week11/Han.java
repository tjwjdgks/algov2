package study.algorithm.study.dk.week11;

import java.util.*;
public class Han {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int [] arr = new int[n];
        Arrays.fill(arr,1);
        for(int i : reserve){
            arr[i-1] +=1;
        }
        for(int i : lost){
            arr[i-1] -=1;
        }
        for(int i=0;i<n;i++){
            if(arr[i]==2){
                if(i-1>=0 && arr[i-1]==0){
                    arr[i] -=1;
                    arr[i-1] +=1;
                }
                else if(i+1<n&& arr[i+1]==0){
                    arr[i] -=1;
                    arr[i+1] +=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]>=1) answer++;
        }
        return answer;
    }
}
