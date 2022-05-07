package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1546 {
    public void getAnswer() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int totaln = Integer.parseInt(bufferedReader.readLine());
        int []arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        int total =0;
        int max = -1;
        for(int i=0; i<totaln;i++){
            if(max< arr[i])
                max = arr[i];
            total += arr[i];
        }
        double answer = (double)total/totaln/max*100;
        System.out.println(answer);
    }
}
