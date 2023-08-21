package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] array = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        int [] sumArr = new int[N];
        sumArr[0] = array[0];
        for(int i=1;i<N;i++){
            sumArr[i] = sumArr[i-1] + array[i];
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) -1;
            int end = Integer.parseInt(st.nextToken()) -1;
            if(start-1>=0){
                sb.append(sumArr[end]- sumArr[start-1]);
            }
            else{
                sb.append(sumArr[end]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
