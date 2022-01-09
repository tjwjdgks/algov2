package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17141 {
    public static int N,M;
    public static List<int[]> arr = new ArrayList<>();
    public static int [][] table;
    public static int [] dy = {-1,0,1,0};
    public static int [] dx = {0,-1,0,1};
    public static int minNum  = Integer.MAX_VALUE;
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        table = new int[N][];
        for(int i=0;i<N;i++){
            table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(num->Integer.parseInt(num)).toArray();
        }
        addVirusPos();
        dfs(0, -1, "");
        if(minNum == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(minNum);
    }

    private static void dfs(int step, int curidx,String s) {
        if(step == M){
            int curNum = bfs(s);
            minNum = Math.min(curNum,minNum);
            return;
        }
        for(int i=curidx+1; i<arr.size();i++){
            dfs(step+1,i,s+i);
        }
    }

    private static int bfs(String step) {
        int answer = Integer.MAX_VALUE;
        boolean [][] checks = new boolean[N][N];
        String [] curidx = step.split("");
        int minNum = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<curidx.length;i++){
            int[] virusIndex = arr.get(Integer.parseInt(curidx[i]));
            checks[virusIndex[0]][virusIndex[1]] = true;
            queue.add(new int[]{virusIndex[0],virusIndex[1],0});
        }
        while(!queue.isEmpty()){
            int [] poll = queue.poll();
            minNum = Math.max(minNum,poll[2]);
            for(int k=0;k<4; k++){
                int tempy  = poll[0] +dy[k];
                int tempx = poll[1] + dx[k];
                if(tempy>=0 && tempx>=0 && tempx<N && tempy<N && !checks[tempy][tempx] && table[tempy][tempx] !=1){
                    checks[tempy][tempx] = true;
                    queue.add(new int[]{tempy,tempx,poll[2]+1});
                }
            }
        }
        if(checkTable(checks)) answer = minNum;
        return answer;
    }
    private static boolean checkTable(boolean[][] curTable){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(table[i][j] != 1 && !curTable[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    private static void addVirusPos() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(table[i][j] == 2){
                    arr.add(new int[]{i,j});
                }
            }
        }

    }
}
