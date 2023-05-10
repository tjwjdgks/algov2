package study.algorithm.study.dk.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sherlock {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;
        int minGap = Integer.MAX_VALUE;
        int minLeftIndex = -1;
        int minRightIndex = -1;
        while(left < right){
            int curGap = arr[left] + arr[right];
            if(minGap>Math.abs(curGap)){
                minGap = Math.abs(curGap);
                minLeftIndex = arr[left];
                minRightIndex = arr[right];
            }
            if(curGap == 0 ) break;
            else if(curGap>0){
                right--;
            }
            else{
                left++;
            }
        }
        System.out.println(minLeftIndex + " " + minRightIndex);
    }
    public static void main(String [] args) throws IOException {
        getAnswer();
    }
}
