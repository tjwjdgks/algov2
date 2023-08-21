package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] array = new int[N][N];
        for(int i=0;i<N; i++){
            array[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        }
        int [][] sum = new int[N][N];
        sum[0][0] = array[0][0];
        for(int i=1;i<N;i++){
            sum[i][0] = sum[i-1][0]+array[i][0];
            sum[0][i] = sum[0][i-1]+array[0][i];
        }
        for(int i=1;i<N;i++){
            for(int j=1;j<N;j++){
                sum[i][j] = array[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<M;i++){
            int [] tempIndex = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)-1).toArray();
            int total = sum[tempIndex[2]][tempIndex[3]];
            if(tempIndex[0] - 1 >= 0){
                total -= sum[tempIndex[0]-1][tempIndex[3]];
            }
            if(tempIndex[1] -1 >=0){
                total -= sum[tempIndex[2]][tempIndex[1]-1];
            }
            if(tempIndex[0]-1 >= 0 && tempIndex[1] -1 >=0){
                total += sum[tempIndex[0]-1][tempIndex[1]-1];
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb.toString());
    }
}
