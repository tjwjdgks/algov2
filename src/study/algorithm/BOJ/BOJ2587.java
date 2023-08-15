package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2587 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] array = new int[5];
        int total = 0;
        for(int i=0;i<5;i++){
            array[i] = Integer.parseInt(br.readLine());
            total += array[i];
        }
        Arrays.sort(array);
        System.out.println(total/5);
        System.out.println(array[2]);
    }
}
