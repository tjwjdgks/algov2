package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1891 {
    // use 1,2,3,4
    public static int dy[] = {-1,0,0,1,1};
    public static int dx[] = {-1,1,0,0,1};
    public static void getAnswer() throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String [] s = br.readLine().split(" ");
        String [] move = br.readLine().split(" ");

        long maxY = 1L<<Integer.parseInt(s[0]);
        long maxX = 1L<<Integer.parseInt(s[0]);

        long n = 1;
        long cury = 0;
        long curx = 0;
        for(int i=s[1].length()-1;i>=0;i--){
            int curidx = s[1].charAt(i)-'0';
            cury += dy[curidx]*n;
            curx += dx[curidx]*n;
            n *=2;
        }
        curx += Long.parseLong(move[0]);
        cury -= Long.parseLong(move[1]);

        if(curx>=0 && cury>= 0 && curx<maxX && cury<maxY){
            StringBuffer sb = new StringBuffer();
            for(int i=s[1].length()-1;i>=0; i--){
                int flagY = 0;
                int flagX = 0;
                long tempy = 1L<<i;
                long tempx = 1L<<i;
                if(cury>=tempy){
                    cury -= tempy;
                    flagY = 1;
                }
                if(curx >= tempx){
                    curx -= tempx;
                    flagX = 1;
                }
                for(int k=1;k<=4;k++){
                    if(flagY == dy[k] && flagX == dx[k])
                        sb.append(k);
                }
            }
            System.out.println(sb.toString());
        }
        else
            System.out.println(-1);
    }
}
