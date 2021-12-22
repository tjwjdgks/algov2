package study.algorithm.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1654 {
    public static void getAnswer() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int target = scanner.nextInt();
        int [] arr=  new int[count];
        for(int i=0; i<count;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        long low = 1;
        long high = arr[arr.length-1];
        long mid = -1;
        long maxnum = -1;
        while(low<=high){
            mid= (low+high)/2;
            int counts = 0;
            for(int i=0; i<arr.length;i++){
                counts += arr[i]/mid;
            }
            if(target<=counts){
                maxnum = Math.max(mid,maxnum);
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        System.out.println(maxnum);
    }
}
