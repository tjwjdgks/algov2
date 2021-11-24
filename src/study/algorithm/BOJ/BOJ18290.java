package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18290 {
    public static int [][] checks;
    public static int [][] arr;
    public static int N,M,K;
    public static int selectNum;
    public static int maxNum = Integer.MIN_VALUE;
    public static int [] dy = {0,1,0,-1,0};
    public static int [] dx = {1,0,-1,0,0};
    public static void dfs(int curstep, int num){
        if(curstep == selectNum){
            maxNum = Math.max(maxNum,num);
            return;
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(checks[i][j]!=0) continue;
                change(i,j,1);
                dfs(curstep+1,num+arr[i][j]);
                change(i,j,-1);
            }
        }
    }
    public static void change(int i, int j, int num){
        for(int k=0;k<5;k++){
            int tempy = i+ dy[k];
            int tempx = j+ dx[k];
            if(tempx>=0 && tempy>=0 && tempy<N && tempx<M)
                checks[tempy][tempx] += num;
        }
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        selectNum = Math.min(K,N*M);
        arr = new int[N][];
        checks = new int[N][M];

        for(int i=0;i<N;i++)
         arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(k->Integer.parseInt(k)).toArray();
        dfs(0,0);
        System.out.println(maxNum);

    }
}
