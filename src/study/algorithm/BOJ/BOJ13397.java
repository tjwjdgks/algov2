package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ13397 {
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] array = Arrays.stream(br.readLine().split(" ")).mapToInt(num->Integer.parseInt(num)).toArray();

        int minNum = 0;
        int maxNum = 10_000;
        while(minNum<maxNum){
            int midNum = (minNum+maxNum)/2;
            if(isPossible(array,midNum,M)){
                maxNum = midNum;
            }
            else{
                minNum = midNum+1;
            }
        }
        System.out.println(minNum);
    }

    private boolean isPossible(int[] array, int midNum, int m) {
        int count = 1;
        int minNum = array[0];
        int maxNum = array[0];
        for(int i=1;i<array.length;i++){
            if(Math.abs(array[i]-minNum)>midNum || Math.abs(array[i]-maxNum)>midNum){
                count++;
                minNum = array[i];
                maxNum = array[i];
            }
            else{
                if(array[i]<minNum){
                    minNum = array[i];
                }
                if(array[i]>maxNum){
                    maxNum = array[i];
                }
            }
        }
        return count<=m;
    }
}
