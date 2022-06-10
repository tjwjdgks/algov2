package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2470 {
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrsize = Integer.parseInt(br.readLine());
        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        Arrays.sort(arr);
        int start =0;
        int end = arrsize-1;
        int targets = -1;
        int targete = -1;
        int gap = Integer.MAX_VALUE;
        while(start<end){
            int curnum = arr[start]+arr[end];
            if(Math.abs(curnum)<gap){
                gap = Math.abs(curnum);
                targets = arr[start];
                targete = arr[end];
            }
            if(curnum<=0){
                start++;
            }
            else{
                end--;
            }
        }
        System.out.println(targets+" "+targete);
    }
}
