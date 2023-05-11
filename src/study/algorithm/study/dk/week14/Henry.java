package study.algorithm.study.dk.week14;

import java.util.LinkedList;
import java.util.Queue;

public class Henry {
    public int[] dy = {0,1,0,-1};
    public int[] dx = {1,0,-1,0};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int [][] table = new int[102][102];
        for(int [] r : rectangle){
            for(int i=r[1]*2;i<=r[3]*2;i++){
                for(int j=r[0]*2;j<=r[2]*2;j++){
                    table[i][j] = 1;
                }
            }
        }
        for(int [] r : rectangle){
            for(int i=r[1]*2+1;i<=r[3]*2-1;i++){
                for(int j=r[0]*2+1;j<=r[2]*2-1;j++){
                    table[i][j] = 0;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterY*2,characterX*2,0});
        while(!queue.isEmpty()){
            int[] curIndex = queue.poll();
            if(curIndex[0] == itemY*2 && curIndex[1] == itemX*2){
                return curIndex[2]/2;
            }
            for(int i=0;i<4;i++){
                int tempy = curIndex[0] + dy[i];
                int tempx = curIndex[1] + dx[i];
                if(tempy>=0 && tempy<=100 && tempx>=0 && tempx<=100 && table[tempy][tempx] == 1){
                    table[tempy][tempx] = 0;
                    queue.add(new int[]{tempy,tempx, curIndex[2]+1});
                }
            }

        }
        return 0;
    }
    public static void main(String[] args){
        Henry h = new Henry();
        h.solution(new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},1,3,7,8);
    }
}
