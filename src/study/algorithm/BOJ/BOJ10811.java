package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ10811 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = i+1;
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            while(start<end){
                int temp = array[start];
                array[start] = array[end];
                array[end]= temp;
                end--;
                start++;
            }
        }
        System.out.println(Arrays.stream(array).mapToObj(i->String.valueOf(i)).collect(Collectors.joining(" ")));
    }
}
