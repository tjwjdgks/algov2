package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ24444 {
    public static List<Integer>[] edges;
    public static int[] check;
    public static int count = 1;
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
        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);
        check[R] = count++;
        while(!queue.isEmpty()){
            int r = queue.poll();
            for(int i : edges[r]){
                if(check[i] == 0){
                    check[i] = count++;
                    queue.add(i);
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=N;i++){
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
