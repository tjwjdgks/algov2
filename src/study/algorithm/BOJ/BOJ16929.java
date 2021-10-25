package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16929 {
    public static char[][] arr;
    public static int [] dy = {0,1,0,-1};
    public static int [] dx = {1,0,-1,0};
    public static int N,M;
    public static boolean [][] check;
    public static void dfs(int count, int y, int x, int standy, int standx){
        check[y][x] = true;
        for(int i=0;i<4;i++){
            int tempy = y +dy[i];
            int tempx = x+ dx[i];
            if(tempy>=0 && tempx>=0 && tempy<N && tempx<M){
                if(arr[tempy][tempx] == arr[y][x] && !check[tempy][tempx])
                    dfs(count+1,tempy,tempx,standy,standx);
                else if(standy == tempy && standx == tempx && count>=4){
                    System.out.println("Yes");
                    System.exit(0);
                }
            }
        }
        check[y][x] = false;
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][];
        check = new boolean[N][M];
        for(int i=0;i<N;i++)
            arr[i] = br.readLine().toCharArray();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                dfs(1,i,j,i,j);
            }
        }
        System.out.println("No");
    }
}
