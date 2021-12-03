package study.algorithm.PROGRAMMERS;

import java.util.ArrayList;
import java.util.List;

public class divideTwo {
    public List<List<Integer>> edges;
    public int getNum(int idx, int prev){
        int answer = 1;
        List<Integer> curEdges = edges.get(idx);
        for(int i: curEdges){
            if(i == prev) continue;
            answer += getNum(i,idx);
        }
        return answer;
    }
    public int solution(int n, int[][] wires) {
        int answer =Integer.MAX_VALUE;
        edges = new ArrayList<>(n+1);
        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }
        for(int i=0;i<wires.length;i++){
            edges.get(wires[i][0]).add(wires[i][1]);
            edges.get(wires[i][1]).add(wires[i][0]);
        }
        for(int i=0;i<wires.length;i++){
            int left = getNum(wires[i][0],wires[i][1]);
            int right = n - left;
            answer = Math.min(answer, Math.abs(left-right));
        }
        return answer;
    }
}
