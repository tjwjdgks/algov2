package study.algorithm.PROGRAMMERS;

import java.util.ArrayList;
import java.util.List;

public class AllToZero {
    public static int [] a_g;
    public static List<Integer>[] list;
    static long total = 0;
    public static long dfs(int cur, int pre){
        if(list[cur].size() == 1 && list[cur].get(0) == pre){
            return -a_g[cur];
        }
        long cur_total = a_g[cur];
        for(int i=0; i<list[cur].size(); i++){
            if(list[cur].get(i) == pre) continue;
            long temp = dfs(list[cur].get(i),cur);
            total += Math.abs(temp);
            cur_total -= temp;
        }
        return -cur_total;

    }
    public long solution(int[] a, int[][] edges) {
        long answer = 0;
        a_g = a;
        list = new List[a.length];
        for(int i=0; i<a.length; i++){
            list[i] = new ArrayList<>();
        }
        for(int [] i : edges){
            list[i[0]].add(i[1]);
            list[i[1]].add(i[0]);
        }
        long c = dfs(0, -1);
        answer = c == 0 ? total : -1;
        return answer;
    }
}
