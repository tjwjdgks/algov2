package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11657 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] array = new int[M][];
        for(int i=0;i<M;i++){
            array[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        }
        int [] count = new int[N];
        Arrays.fill(count, Integer.MAX_VALUE/2);
        count[0] = 0;
        boolean circle = false;
        for(int i=1;i<=N;i++){
            for(int j=0;j<M;j++){
                int start = array[j][0]-1;
                int end = array[j][1]-1;
                int val = array[j][2];
                if(count[start] != Integer.MAX_VALUE/2 && count[start]+val < count[end]){
                    if(i == N){
                        circle = true;
                    }
                    count[end] = count[start]+val;
                }
            }
        }
        if(circle){
            System.out.println(-1);
        }
        else{
            for(int i=1;i<N;i++){
                if(count[i] != Integer.MAX_VALUE/2){
                    System.out.println(count[i]);
                }
                else{
                    System.out.println(-1);
                }
            }
        }
    }
}
