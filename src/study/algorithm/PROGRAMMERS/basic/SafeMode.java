package study.algorithm.PROGRAMMERS.basic;

public class SafeMode {
    public int [] dy = {-1, -1, -1, 0, 0 , 1, 1, 1};
    public int [] dx = {-1,0,1,-1,1,-1,0,1};
    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean [][] checked = new boolean[n][m];
        for(int i = 0; i< n ; i++ ){
            for(int j= 0; j<m; j ++ ){
                if(board[i][j] == 0 ) continue;
                checked[i][j] = true;
                for(int k = 0; k<8;k++){
                    int tempy = i + dy[k];
                    int tempx = j + dx[k];
                    if(tempy>=0 && tempx >= 0 && tempy< n && tempx <m){
                        checked[tempy][tempx] = true;
                    }
                }
            }
        }
        int answer = 0;
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(checked[i][j] == false) answer++;
            }
        }
        return answer;
    }

}
