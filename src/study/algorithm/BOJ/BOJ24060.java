package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ24060 {

    public static int countNum = 0;
    public static int target = -1;
    public static int answer = -1;
    public static boolean flag = false;
    public static int [] tempArr;
    public static void mergeSort(int [] array, int start, int end){
        if (flag) return;
        if(start < end ){
            int mid = (start+end)/2;
            mergeSort(array, start, mid);
            mergeSort(array, mid+1, end);
            merge(array, start, mid, end);
        }
    }
    public static void merge(int[] array, int start, int mid, int end){
        int tempLeftStart = start;
        int tempRightStart = mid+1;
        int tempIndex = 0;
        while(tempLeftStart<=mid && tempRightStart<=end){
            if(array[tempLeftStart]<=array[tempRightStart])
                tempArr[tempIndex++] = array[tempLeftStart++];
            else tempArr[tempIndex++] = array[tempRightStart++];
        }
        while(tempLeftStart<=mid){
            tempArr[tempIndex++] = array[tempLeftStart++];
        }
        while(tempRightStart<=end){
            tempArr[tempIndex++] = array[tempRightStart++];
        }
        int arrayIndex = start;
        tempIndex = 0;
        while(arrayIndex <= end){
            countNum++;
            if(countNum == target){
                answer = tempArr[tempIndex];
                flag = true;
            }
            array[arrayIndex++] = tempArr[tempIndex++];
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        tempArr = new int[N];
        int [] array = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        mergeSort(array, 0, array.length-1);
        System.out.println(answer);

    }
}
