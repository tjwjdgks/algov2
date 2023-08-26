package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ24479 {
    public static List<Integer>[] edges;
    public static int[] check;
    public static int count = 1;
    public static void dfs(int e){
        check[e] = count++;
        for(int i : edges[e]){
            if(check[i] == 0){
                dfs(i);
            }
        }
    }
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        edges = new List[N+1];
        check = new int[N+1];
        for(int i=0; i<=N;i++){
            edges[i] = new ArrayList<>();
        }
        for(int i=0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }
        for(int i =0; i<=N;i++) {
            Collections.sort(edges[i]);
        }
        dfs(R);
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=N;i++){
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
