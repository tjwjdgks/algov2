package study.algorithm.PROGRAMMERS;

public class DisapearBoard {
    public int [] dy = {0,1,-1,0};
    public int [] dx = {1,0,0,-1};
    public int[][] board_g;
    public int n,m;
    public int dfs(boolean[][] check, int alocy, int alocx, int blocy, int blocx){
        if(check[alocy][alocx]) return 0;
        int num = 0;
        for(int i=0;i<4;i++){
            int tempy = alocy + dy[i];
            int tempx = alocx + dx[i];
            if(tempy>=0&& tempx>=0 && tempy<n && tempx<m && board_g[tempy][tempx] ==1 && !check[tempy][tempx]){
                check[alocy][alocx] = true;
                int curNum = dfs(check, blocy, blocx, tempy, tempx) +1;
                check[alocy][alocx] = false;
                if(num%2 == 0  && curNum%2 == 1){
                    num = curNum;
                }
                else if(num%2 == 0 && curNum%2 == 0){
                    num = Math.max(num, curNum);
                }
                else if(num%2 ==1 && curNum%2 == 1){
                    num = Math.min(num, curNum);
                }
            }
        }
        return num;
    }
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        int answer = 0;
        board_g = board;
        n = board.length;
        m = board[0].length;
        boolean[][] check = new boolean[n][m];
        answer = dfs(check, aloc[0], aloc[1], bloc[0], bloc[1]);
        return answer;
    }
}