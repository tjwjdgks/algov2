package study.algorithm.study.dk.week13;

public class Han {
    public int minNum = Integer.MAX_VALUE;
    public int dfs(int n, boolean [][] edge, int start){
        int subNum = 1;
        for(int i=0;i<edge[start].length;i++){
            if(edge[start][i]){
                edge[i][start] = false;
                subNum += dfs(n,edge,i);
            }
        }
        minNum = Math.min(minNum, Math.abs((n-subNum)-subNum));
        return subNum;
    }
    public int solution(int n, int[][] wires) {

        boolean [][] edge = new boolean[n][n];
        for(int[] wire : wires){
            edge[wire[0]-1][wire[1]-1] = true;
            edge[wire[1]-1][wire[0]-1] = true;
        }
        dfs(n,edge, 0);

        return minNum;
    }
}
