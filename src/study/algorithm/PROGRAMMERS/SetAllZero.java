package study.algorithm.PROGRAMMERS;

import java.util.*;
public class SetAllZero {
    public long answer = 0;
    public List<Integer>[] edgesList;
    public int [] a_g;
    public long dfs(int node, int pre){
        if(edgesList[node].size() == 1 && edgesList[node].get(0) == pre ){
            return -a_g[node];
        }
        long val = a_g[node];
        for(int i=0;i<edgesList[node].size();i++){
            if(pre == edgesList[node].get(i)) continue;
            long curNum =  dfs(edgesList[node].get(i), node);
            answer += Math.abs(curNum);
            val -= curNum;
        }
        return -val;
    }
    public long solution(int[] a, int[][] edges) {
        edgesList = new List[a.length];
        a_g = a;
        for(int i=0;i<a.length;i++){
            edgesList[i] = new ArrayList<>();
        }
        for(int [] i : edges){
            edgesList[i[0]].add(i[1]);
            edgesList[i[1]].add(i[0]);
        }
        long num = dfs( 0, -1);
        return (num == 0) ? answer : -1;
    }
}
