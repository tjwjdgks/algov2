package study.algorithm.PROGRAMMERS.kakao2022;

public class seven {
    public static int[] dy = {0,1,-1,0};
    public static int[] dx = {1,0,0,-1};
    public static int N,M;
    public static boolean [][] check = new boolean[5][5];
    public static int[][] board_g = new int[5][5];
    // 이길려고 하는 것이 목적
    public static int dfs(int y1, int x1, int y2, int x2){
        if(check[y1][x1]) return 0;
        int ret = 0;
        for(int i=0;i<4;i++){
            int tempy =  y1+dy[i];
            int tempx =  x1+dx[i];
            if(isIn(tempy,tempx) && board_g[tempy][tempx]==1 &&!check[tempy][tempx]){
                check[y1][x1] = true;
                int curNum = dfs(y2,x2,tempy,tempx)+1;
                check[y1][x1] = false;
                if(ret%2==0 && curNum%2==1) ret = curNum;
                else if(ret%2==0 && curNum%2==0) ret = Math.max(ret,curNum);
                else if(ret%2==1 && curNum%2==1) ret = Math.min(ret,curNum);
            }
        }
        return ret;
    }

    private static boolean isIn(int tempy, int tempx) {
        return tempy>=0 && tempx>=0 && tempy<N && tempx<M;
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        N = board.length;
        M = board[0].length;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                board_g[i][j]= board[i][j];
            }
        }
        int answer = dfs(aloc[0],aloc[1],bloc[0],bloc[1]);
        return answer;
    }

}
