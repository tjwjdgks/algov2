package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11404 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int [][] edges = new int[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(edges[i], Integer.MAX_VALUE/2);
            edges[i][i] = 0;
        }
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            edges[start][end] = Math.min(edges[start][end], price);
        }
        for(int i=0;i<N; i++){
            for(int j=0;j<N; j++){
                for(int k=0;k<N; k++){
                    edges[j][k] = Math.min(edges[j][k], edges[j][i] + edges[i][k]);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(edges[i][j] == Integer.MAX_VALUE/2) sb.append(0).append(" ");
                else sb.append(edges[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
