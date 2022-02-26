package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2477 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[6];
        for(int i=0;i<6;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int maxNum = -1;
        int maxNumIdx = -1;
        for(int i=0;i<6;i++){
            if(maxNum<arr[i]){
                maxNum = arr[i];
                maxNumIdx = i;
            }
        }

        int preIdx = maxNumIdx == 0? 5 : maxNumIdx-1;
        int nextIdx = maxNumIdx == 5? 0: maxNumIdx+1;

        int total = -1;
        if(arr[preIdx] > arr[nextIdx]){
            total = arr[preIdx] * arr[maxNumIdx];

            total -= arr[(maxNumIdx+2)%6] * arr[(maxNumIdx+3)%6];

        }
        else{
            total = arr[nextIdx] * arr[maxNumIdx];
            total -= arr[(nextIdx+2)%6] * arr[(nextIdx+3)%6];

        }
        System.out.println(total*N);
    }
}
