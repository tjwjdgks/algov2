package study.algorithm.study.dk.week13;

import java.util.LinkedList;
import java.util.Queue;

public class Ned {
    public int[] dy = {0,1,0,-1};
    public int[] dx = {1,0,-1,0};
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        int [][] checkMaps = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        checkMaps[0][0] = 1;
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] curIndex = queue.poll();
            for(int i=0;i<4;i++){
                int tempy = curIndex[0] + dy[i];
                int tempx = curIndex[1] + dx[i];
                if(tempy>=0 && tempx >=0 && tempy<n && tempx<m && maps[tempy][tempx] == 1 && checkMaps[tempy][tempx] == 0){
                    checkMaps[tempy][tempx] = checkMaps[curIndex[0]][curIndex[1]]+1;
                    if(tempy == n-1 && tempx == m-1) return checkMaps[tempy][tempx];
                    queue.add(new int[]{tempy,tempx});
                }
            }
        }
        return -1;
    }
}
