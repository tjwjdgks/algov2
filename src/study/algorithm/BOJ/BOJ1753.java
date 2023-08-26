package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine())-1;
        int[][] edges = new int[V][V];
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken())-1;
            int second = Integer.parseInt(st.nextToken())-1;
            int num = Integer.parseInt(st.nextToken());
            edges[first][second] = edges[first][second] != 0 ? Math.min(edges[first][second], num) : num;
        }
        int [] array = new int[V];
        Arrays.fill(array,Integer.MAX_VALUE/2);
        array[start] = 0;
        Queue<int[]> queue = new PriorityQueue<>((o1,o2)->{
            return o1[0] - o2[0];
        });
        queue.add(new int[]{0,start});
        while(!queue.isEmpty()){
            int[] index = queue.poll();
            for(int i=0;i<V;i++){
                if(edges[index[1]][i] == 0 ) continue;
                if(index[0]+edges[index[1]][i] < array[i]){
                    array[i] = index[0] + edges[index[1]][i];
                    queue.add(new int[]{index[0]+edges[index[1]][i], i});
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<V;i++){

            if(array[i] == Integer.MAX_VALUE/2){
                sb.append("INF").append("\n");
            }
            else sb.append(array[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
