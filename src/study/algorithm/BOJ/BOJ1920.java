package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1920 {
    public static boolean binarySearch(int [] arr ,int target){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(target == arr[mid])
                return true;
            else if(arr[mid]<target)
                left = mid+1;
            else
                right = mid-1;
        }
        return false;
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] oarr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        int M = Integer.parseInt(br.readLine());
        int [] tarr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        Arrays.sort(oarr);

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<tarr.length;i++){
            if(binarySearch(oarr,tarr[i])){
                sb.append("1\n");
            }
            else
                sb.append("0\n");
        }
        System.out.println(sb.toString());
    }
}
