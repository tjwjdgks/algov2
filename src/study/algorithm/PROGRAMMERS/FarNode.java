package study.algorithm.PROGRAMMERS;

import java.util.LinkedList;
import java.util.Queue;

public class FarNode {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Queue<int[]> list = new LinkedList<>();
        boolean [][] edgeArr = new boolean[n+1][n+1];
        for(int [] i : edge){
            edgeArr[i[0]][i[1]] = true;
            edgeArr[i[1]][i[0]] = true;
        }
        boolean [] check = new boolean[n+1];
        list.add(new int[]{1,0});
        int val = -1;
        check[1] = true;
        while(!list.isEmpty()){
            int[] curarr = list.poll();
            if(curarr[1]> val){
                val = curarr[1];
                answer = 1;
            }
            else if(curarr[1] == val){
                answer ++;
            }
            for(int i=1; i<=n;i++){
                if(check[i] == false && edgeArr[curarr[0]][i] == true){
                    check[i] = true;
                    list.add(new int[]{i,curarr[1]+1});
                }
            }
        }
        return answer;
    }
}
