package study.algorithm.PROGRAMMERS;

public class DimensionCoin {
    public int n,m;
    public int[][] target_g;
    public int minAnswer = Integer.MAX_VALUE;
    public int check = 0;
    public void dfs(int[][] board, int step, int changed, int diffCount){
        if(step == (n+m)){
            return;
        }

        if(diffCount == 0){
            minAnswer = Math.min(minAnswer, changed);
        }
        dfs(board, step+1, changed, diffCount);
        int changeCount = doChange(board, step);
        dfs(board, step+1, changed+1, diffCount+changeCount);
        changeCount = doChange(board, step);
    }
    public int doChange(int[][] board, int step){
        int len = (step<n) ? m : n;
        int total = 0;
        for(int i=0;i<len;i++){
            if(step<n){
                board[step][i] = board[step][i] == 1 ? 0 : 1;
                total += board[step][i] == target_g[step][i] ? -1 : 1;
            }
            else{
                board[i][step-n] = board[i][step-n] ==1 ? 0: 1;
                total += board[i][step-n] == target_g[i][step-n] ? -1 : 1;
            }
        }
        return total;

    }

    public int solution(int[][] beginning, int[][] target) {
        int answer = 0;
        target_g = target;
        n = beginning.length;
        m = beginning[0].length;
        int initDiff = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(beginning[i][j] != target[i][j]){
                    initDiff++;
                }
            }
        }
        dfs(beginning, 0, 0, initDiff);
        System.out.println(check);
        answer = (minAnswer == Integer.MAX_VALUE) ? -1 : minAnswer;
        return answer;
    }
    public static void main(String[] args){
        DimensionCoin d = new DimensionCoin();
        //d.solution(new int[][]{{0, 1, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}},
                //new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}});
        d.solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, new int[][]{{1, 0, 1}, {0, 0, 0}, {0, 0, 0}});
        //d.solution(new int[][]{{0, 0, 1, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}},
        //        new int[][]{{0, 0, 1, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}});
    }
}
