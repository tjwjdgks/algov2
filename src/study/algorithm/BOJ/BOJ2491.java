package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2491 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        int maxLenth =  Math.max(getMax(arr),getMaxReverse(arr));
        System.out.println(maxLenth);
    }

    private static int getMaxReverse(int[] arr) {
        int maxCount = 0;
        int totalCount = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]<arr[i]){
                maxCount = Math.max(totalCount,maxCount);
                totalCount =1;
            }
            else{
                totalCount++;
            }
        }
        maxCount= Math.max(totalCount,maxCount);
        return maxCount;
    }

    private static int getMax(int[] arr) {
        int maxCount = 0;
        int totalCount = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]>arr[i]){
                maxCount = Math.max(totalCount,maxCount);
                totalCount =1;
            }
            else{
                totalCount++;
            }
        }
        maxCount= Math.max(totalCount,maxCount);
        return maxCount;
    }
}
