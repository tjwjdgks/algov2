package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109 {
    public static String[] s;
    public static boolean[][] checkArr;
    public static int[] dir = {-1,0,1};
    public static int answer = 0;
    public static int N,M;
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        s = new String[N];
        for(int i=0;i<N;i++){
            s[i] = br.readLine();
        }
        checkArr = new boolean[N][M];

        for(int i=0;i<N;i++){
            dfs(i,0);
        }
        System.out.println(answer);
    }

    private static boolean dfs(int row, int col) {
        checkArr[row][col] = true;
        if(col == M-1){
            answer++;
            return true;
        }
        for(int i=0;i<3;i++){
            int tempr = row+dir[i];
            int tempc = col+1;
            if(tempr>=0 && tempc>=0 && tempr<N && tempc<M &&  !checkArr[tempr][tempc] && s[tempr].charAt(tempc) == '.'){
                if(dfs(tempr,tempc)) return true;
            }
        }
        return false;
    }
}
