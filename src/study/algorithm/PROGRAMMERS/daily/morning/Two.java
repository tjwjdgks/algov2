package study.algorithm.PROGRAMMERS.daily.morning;

public class Two {
    public int totalPossibleCount = 0;
    public void dfs(int depth, int total, int idx, int[] number){
        if(depth == 3) {
            if(total == 0 ) totalPossibleCount++;
            return;
        }
        for(int i =idx+1; i<number.length;i++){
            dfs(depth+1, total+number[i], i, number);
        }
    }
    public int solution(int[] number) {
        dfs(0,0, -1,number);
        return totalPossibleCount;
    }

}
