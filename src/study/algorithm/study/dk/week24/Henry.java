package study.algorithm.study.dk.week24;

public class Henry {
    public int [] dy = {0,1,0,-1};
    public int [] dx = {1,0,-1,0};
    public int [][] board_g;
    public boolean [][] check;
    public int N, M;
    public int dfs(int y1, int x1, int y2, int x2){
        if(check[y1][x1]){
            return 0;
        }
        int ret = 0;
        for(int i=0;i<4;i++){
            int tempy = y1+dy[i];
            int tempx = x1+dx[i];
            if(isIn(tempy,tempx) && board_g[tempy][tempx] ==1 && check[tempy][tempx] == false){
                check[y1][x1] = true;
                int count = dfs(y2,x2, tempy,tempx)+1;
                check[y1][x1] = false;
                // 이기는 경우
                if(ret%2 == 0 && count%2 == 1) ret = count;
                    // 지는 경우
                else if(ret%2 == 0 && count%2 == 0) ret = Math.max(ret, count);
                    // 이기는 경우
                else if(ret%2 == 1 && count%2 == 1) ret = Math.min(ret, count);
            }
        }
        return ret;
    }
    public boolean isIn(int y, int x){
        return y>=0 && x>=0 && y<N && x<M;
    }
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        N = board.length;
        M = board[0].length;
        board_g = board;
        check = new boolean[N][M];
        int answer = dfs(aloc[0], aloc[1], bloc[0], bloc[1]);
        return answer;
    }

}
