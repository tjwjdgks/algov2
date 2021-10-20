package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ17103 {
    public static final int MAX = 1_000_001;
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] numArr  = new int[N];
        List<Integer> decimalArr = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++)
            numArr[i] = Integer.parseInt(br.readLine());
        boolean []isDecimal = new boolean[MAX];
        isDecimal[0] = true;
        isDecimal[1] = true;
        for(int i=2;i<MAX;i++){
            if(isDecimal[i]==false){
                decimalArr.add(i);
                int count = i+i;
                while(count<MAX){
                    isDecimal[count] = true;
                    count += i;
                }
            }
        }
        for(int i : numArr){
            int count =0;
            for(int j : decimalArr){
                if(j>i) break;
                if(!isDecimal[i-j])
                    count++;
            }
            if(!isDecimal[i/2])
                count = count/2+1;
            else
                count /=2;
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}
