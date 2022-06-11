package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1015 {
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N][2];
        int [] answer = new int[N];

        int [] target = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        for(int i=0;i<target.length;i++){
            arr[i][0] = target[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr,((o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0]-o2[0];
        }));

        for(int i=0;i<arr.length;i++){
            answer[arr[i][1]] = i;
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<arr.length;i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
