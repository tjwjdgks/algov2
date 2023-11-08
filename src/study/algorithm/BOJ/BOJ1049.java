package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] setArray = new int[M];
        int [] individualArray = new int[M];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int set  = Integer.parseInt(st.nextToken());
            int individual = Integer.parseInt(st.nextToken());
            setArray[i] = set;
            individualArray[i] = individual;
        }
        Arrays.sort(setArray);
        Arrays.sort(individualArray);
        int val = N/6;
        int rest = N%6;
        int valTotal = Math.min(val*setArray[0], val*6*individualArray[0]);
        int restTotal = Math.min(setArray[0], rest*individualArray[0]);
        System.out.println(valTotal+restTotal);
    }
}
