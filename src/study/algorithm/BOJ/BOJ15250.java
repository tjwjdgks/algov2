package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15250 {
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        StringBuilder sb  = new StringBuilder();
        for(int i=0; i<cases;i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(k->Integer.parseInt(k)).toArray();
            int floor =  arr[2]%arr[0];
            int room = arr[2]/arr[0];
            if(floor != 0)
                room = room+1;
            if(floor== 0)
                floor = arr[0];
            sb.append(floor).append(room<10?"0":"").append(room).append("\n");
        }
        System.out.println(sb.toString());

    }
}
