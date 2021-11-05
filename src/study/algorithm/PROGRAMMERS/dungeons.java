package study.algorithm.PROGRAMMERS;

public class dungeons {
    public boolean [] checkIdx;
    public int N = -1;
    public int answer  = 0;
    public int K = -1;
    public int [][] Dungeon;
    public int getMaxDungeon(String array){
        int curstatus = K;
        int curtotal = 0;
        for(int i=0;i<array.length();i++){
            int curidx = array.charAt(i)-'1';
            if(Dungeon[curidx][0]<=curstatus){
                curstatus -= Dungeon[curidx][1];
                curtotal++;
            }
        }
        return curtotal;
    }
    public void possibleAllArray(int step, int sum){
        if(step == N){
            answer = Math.max(answer, getMaxDungeon(Integer.toString(sum)));
            return;
        }
        for(int i=0;i<N;i++){
            if(checkIdx[i]) continue;
            checkIdx[i] = true;
            possibleAllArray(step+1,sum*10+(i+1));
            checkIdx[i] = false;
        }
    }
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        K = k;
        Dungeon = dungeons;
        checkIdx = new boolean[N];
        possibleAllArray(0,0);

        return answer;
    }
}
