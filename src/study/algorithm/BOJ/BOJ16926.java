package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16926 {
    public static int N,M,R;
    public static int [][] arr;
    public static void moveROutLine(int starty, int endy, int startx, int endx, int R){
        int N = endy-starty+1;
        int M = endx - startx +1;
        int total = N*2 + M*2 - 4;
        int [] line = new int[total];
        int idx =0;
        int curidx_y = starty;
        int curidx_x = startx;
        for(int i=0;i<M-1;i++)
            line[idx++] = arr[curidx_y][curidx_x++];
        for(int i=0;i<N-1;i++)
            line[idx++] = arr[curidx_y++][curidx_x];
        for(int i=0;i<M-1;i++)
            line[idx++] = arr[curidx_y][curidx_x--];
        for(int i=0;i<N-1;i++)
            line[idx++] = arr[curidx_y--][curidx_x];

        curidx_y = starty;
        curidx_x = startx;
        idx = R;
        for(int i=0;i<M-1;i++,idx++)
            arr[curidx_y][curidx_x++] = line[idx%total];
        for(int i=0;i<N-1;i++,idx++)
            arr[curidx_y++][curidx_x] = line[idx%total];
        for(int i=0;i<M-1;i++,idx++)
            arr[curidx_y][curidx_x--] = line[idx%total];
        for(int i=0;i<N-1;i++,idx++)
            arr[curidx_y--][curidx_x] = line[idx%total];
    }
    public static void print(){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][];
        for(int i=0;i<N;i++)
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(num->Integer.parseInt(num)).toArray();
        int starty = 0, startx =0;
        int endy = N-1, endx = M-1;
        while(starty<endy && startx<endx){
            moveROutLine(starty,endy,startx,endx,R);
            starty +=1;
            startx +=1;
            endy -=1;
            endx -=1;
        }
        print();
    }
}
