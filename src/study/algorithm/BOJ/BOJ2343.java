package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2343 {
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int maxInt = 0;
        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        for(int i : arr){
            maxInt = Math.max(maxInt,i);
        }
        int left = maxInt;
        int right = maxInt * arr.length;
        while(left<right){
            int mid = (left+right)/2;
            if(isPossible(mid,m,arr)){
                right = mid;
            }
            else left = mid+1;
        }
        System.out.println(right);
    }
    public boolean isPossible(int standard, int m, int [] arr){
        int totalCount = 0;
        int totalNum = 0;
        for(int i=0;i<arr.length;i++){
            if(totalCount+ arr[i]>standard){
                totalCount = 0;
                totalNum++;
            }
            totalCount += arr[i];
        }
        totalNum++;
        return totalNum<=m;
    }
}
