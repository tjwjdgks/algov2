package study.algorithm.PROGRAMMERS.basic;

import java.util.*;
public class PumpOil {
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        int currentArea = 2;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j] == 1) {
                    map.put(currentArea, dfs(i,j,land,currentArea++));
                }
            }
        }
        int answer = 0;
        for(int i=0; i<m; i++){
            Set<Integer> hashSet = new HashSet<>();
            int total = 0;
            for(int j=0; j<n; j++) {
                if(land[j][i] != 0 && !hashSet.contains(land[j][i])) {
                    total += map.get(land[j][i]);
                    hashSet.add(land[j][i]);
                }
            }
            answer = Math.max(answer, total);
        }
        return answer;
    }
    public int dfs(int y, int x, int[][] land, int curArea){
        if(y<0 || x<0 || y>=land.length || x>=land[0].length) return 0;
        if(land[y][x] != 1) return 0;
        land[y][x] = curArea;
        int total = 1;
        total += dfs(y+1, x, land, curArea);
        total += dfs(y-1, x, land, curArea);
        total += dfs(y, x+1, land, curArea);
        total += dfs(y, x-1, land, curArea);
        return total;
    }
}
