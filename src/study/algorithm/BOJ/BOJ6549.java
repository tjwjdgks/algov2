package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ6549 {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        while(true){
            int [] array = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
            if(array.length == 1 && array[0] == 0) break;
            long answer = dfs(array, 1, array.length-1);
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static long dfs(int[] array, int start, int end){
        if(start == end){
            return array[end];
        }
        int mid = (start+end)/2;
        long leftMax = dfs(array, start, mid);
        long rightMax = dfs(array, mid+1, end);
        long middleMax = getArea(array, start, end);
        return Math.max(middleMax, Math.max(leftMax, rightMax));
    }
    public static long getArea(int[] array, int start, int end){
        long total = array[(start+end)/2];
        int left = (start+end)/2-1;
        int right = (start+end)/2+1;
        int count = 1;
        int minNum = array[(start+end)/2];
        while(left>=start && right<=end){
            count++;
            if(array[left] > array[right]){
                minNum = Math.min(minNum, array[left]);
                left--;

            }
            else{
                minNum = Math.min(minNum, array[right]);
                right++;
            }
            total = Math.max(total, (long)minNum*count);
        }
        while(left>=start){
            count++;
            minNum = Math.min(minNum, array[left]);
            left--;
            total = Math.max(total, (long)minNum*count);
        }
        while(right<=end){
            count++;
            minNum = Math.min(minNum, array[right]);
            right++;
            total = Math.max(total, (long)minNum*count);
        }
        return total;
    }
}
