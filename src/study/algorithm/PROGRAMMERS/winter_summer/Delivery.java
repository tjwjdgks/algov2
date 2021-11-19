package study.algorithm.PROGRAMMERS.winter_summer;

import java.util.*;

public class Delivery {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int [][] edges = new int[N+1][N+1];
        boolean [] nodes = new boolean[N+1];
        for(int i=1;i<=N;i++)
            Arrays.fill(edges[i],Integer.MAX_VALUE/2);
        for(int [] edge : road){
            edges[edge[0]][edge[1]] = Math.min(edges[edge[0]][edge[1]],edge[2]);
            edges[edge[1]][edge[0]] = Math.min(edges[edge[1]][edge[0]],edge[2]);
        }

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.add(new int[]{1,0});

        while(!queue.isEmpty()){
            int [] n = queue.poll();
            if(nodes[n[0]]) continue;
            nodes[n[0]] = true;
            answer++;
            for(int i=1;i<=N;i++){
                if(edges[n[0]][i] + n[1] <=K){
                    queue.add(new int[]{i,edges[n[0]][i]+n[1]});
                }
            }
        }
        return answer;
    }
}
