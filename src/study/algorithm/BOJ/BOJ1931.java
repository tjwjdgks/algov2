package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] array = new int[N][];
        for(int i=0;i<N;i++){
            array[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        }
        Arrays.sort(array, (o1,o2)->{
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        int count = 1;
        int endTime = array[0][1];
        for(int i=1;i<N;i++){
            if(array[i][0]< endTime) continue;
            endTime = array[i][1];
            count++;
        }
        System.out.println(count);
    }
}
