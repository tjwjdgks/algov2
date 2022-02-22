package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2480 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        Arrays.sort(arr);

        if(arr[0] == arr[1] && arr[1] == arr[2])
            System.out.println(10000+ arr[0]*1000);
        else if(arr[0] == arr[1] || arr[1] == arr[2])
            System.out.println(1000+ arr[1]*100);
        else
            System.out.println(arr[2]*100);

    }
}
