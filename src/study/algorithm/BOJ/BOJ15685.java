package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15685 {

    public static boolean [][] table = new boolean[101][101];
    public static int [] dy = {0,-1,0,1};
    public static int [] dx  = {1,0,-1,0};

    public static void checkDragonCurve(int x, int y, int d, int g){
        List<int[]> current = new ArrayList<>();
        int stand_y = y+ dy[d];
        int stand_x = x + dx[d];

        current.add(new int[]{y,x,d});
        table[y][x] = true;

        for(int i=0;i<g;i++){
            for(int j=current.size()-1; j>=0;j--){
                int [] numidx = current.get(j);
                int curdirection = (numidx[2]+1)%4;
                current.add(new int[]{stand_y,stand_x,curdirection});

                table[stand_y][stand_x] = true;

                stand_y = stand_y + dy[curdirection];
                stand_x = stand_x + dx[curdirection];
            }
        }

        table[stand_y][stand_x] = true;
    }

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            checkDragonCurve(x,y,d,g);
        }
        int answer = calRoom();
        System.out.println(answer);
    }

    private static int calRoom() {
        int answer  = 0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(table[i][j]&&table[i+1][j]&&table[i][j+1]&& table[i+1][j+1]) answer++;
            }
        }
        return answer;
    }
}
