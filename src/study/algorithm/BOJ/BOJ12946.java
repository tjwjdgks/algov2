package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12946 {
    public static int N;
    public static String [] tables;
    public static int[][] checksArr;
    public static int []dx = { -1,-1,0,0,1,1 };
    public static int []dy = { 0,1,-1,1,-1,0 };
    public static int answer = 0;
    public static void dfs(int y, int x, int num){
        checksArr[y][x] = num;
        answer = Math.max(answer,1);
        for(int i=0;i<6;i++){
            int tempy = y + dy[i];
            int tempx = x + dx[i];
            if(tempy>=0 && tempx>=0 && tempy<N && tempx<N){
                if(tables[tempy].charAt(tempx) !='X') continue;
                if(checksArr[tempy][tempx]== 0 ) dfs(tempy,tempx,-num);
                answer = Math.max(answer,2);
                if(checksArr[tempy][tempx] == num) answer = Math.max(answer,3);
            }
        }
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tables = new String[N];
        checksArr = new int[N][N];
        for(int i=0;i<N;i++)
            tables[i] = br.readLine();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(tables[i].charAt(j) == 'X' && checksArr[i][j]  ==0){
                    dfs(i,j,1);
                }
            }
        }
        System.out.println(answer);
    }
}
