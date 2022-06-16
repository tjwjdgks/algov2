package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1913 {
    public int [] dy = {1,0,-1,0};
    public int [] dx = {0,1,0,-1};
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int [][] array = new int[N][N];
        boolean [][] check = new boolean[N][N];
        int count = N*N;
        int curY = 0;
        int curX = 0;
        int dir = 0;
        while(count>0){
            array[curY][curX] = count;
            check[curY][curX] = true;

            int nextY = curY+dy[dir];
            int nextX = curX+dx[dir];
            if(nextY<0 || nextY>=N || nextX<0 || nextX>=N || check[nextY][nextX] == true){
                dir = (dir+1)%4;
                curX = curX + dx[dir];
                curY = curY + dy[dir];
            }
            else{
                curX = nextX;
                curY = nextY;
            }
            count--;
        }
        int targetY = -1;
        int targetX = -1;

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            for(int j=0; j<N; j++){
                if(array[i][j] == target){
                    targetY = i;
                    targetX = j;
                }
                sb.append(array[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        System.out.println((targetY+1) + " "+(targetX+1));
    }

}
