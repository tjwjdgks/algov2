package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16197 {
    public static int []dy = {0,0,-1,1};
    public static int []dx = {-1,1,0,0};
    public static int N,M;
    public static char[][] table;
    public static int minNum = Integer.MAX_VALUE;
    public static void dfs(int step, int tryNum,int c1y,int c1x, int c2y, int c2x){
        if(step>10){
            return;
        }
        if(isInside(c1y,c1x) == false && isInside(c2y,c2x) == false) return;
        if((isInside(c1y,c1x)&&isInside(c2y,c2x)) == false){
            minNum = Math.min(minNum,tryNum);
            return;
        }
        for(int i=0;i<4;i++){
            int tempc1y = c1y + dy[i];
            int tempc1x = c1x + dx[i];

            int tempc2y = c2y + dy[i];
            int tempc2x = c2x + dx[i];

            if(isInside(tempc1y,tempc1x) && table[tempc1y][tempc1x] == '#'){
                tempc1y = c1y;
                tempc1x = c1x;
            }
            if(isInside(tempc2y,tempc2x)&& table[tempc2y][tempc2x] == '#'){
                tempc2y = c2y;
                tempc2x = c2x;
            }
            dfs(step+1,tryNum+1,tempc1y,tempc1x,tempc2y,tempc2x);
        }

    }
    public static boolean isInside(int y, int x){
        if(y>=0 && x>=0 && y<N && x<M) return true;
        else return false;
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        table = new char[N][];
        for(int i=0;i<N;i++)
            table[i] = br.readLine().toCharArray();

        int coin1_x = 0;
        int coin1_y = 0;
        int coin2_x =0;
        int coin2_y = 0;
        boolean flag = false;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(table[i][j] == 'o' && !flag){
                    flag = true;
                    coin1_y = i;
                    coin1_x = j;
                    table[i][j] ='.';
                }
                else if(table[i][j] == 'o' && flag){
                    coin2_y = i;
                    coin2_x = j;
                    table[i][j] = '.';
                }
            }
        }
        dfs(0,0,coin1_y,coin1_x,coin2_y,coin2_x);
        if(minNum == Integer.MAX_VALUE)
            System.out.println(-1);
        else System.out.println(minNum);
    }
}
