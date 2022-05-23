package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1952 {
    public int [] dy = {0,1,0,-1};
    public int [] dx = {1,0,-1,0};
    public int N,M;
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean[][] check = new boolean[N][M];
        int cury = 0;
        int curx = 0;
        int curDir = 0;
        int count=0;
        int answer =0;
        check[cury][curx] = true;
        while(count<N*M){
            int tempy = cury + dy[curDir];
            int tempx = curx + dx[curDir];
            if(!isIN(tempy,tempx) || check[tempy][tempx] == true){
                curDir = (curDir+1)%4;
                cury = cury + dy[curDir];
                curx = curx + dx[curDir];
                answer++;
            }
            else{
                cury = tempy;
                curx = tempx;
            }
            check[cury][curx]= true;
            count++;
        }
        System.out.println(answer-1);
    }

    private boolean isIN(int tempy, int tempx) {
        return tempy>=0 && tempy<N && tempx>=0 && tempx<M;
    }
}
