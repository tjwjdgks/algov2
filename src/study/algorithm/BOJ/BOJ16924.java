package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16924 {
    public static int[] dy = {0,0,1,-1};
    public static int[] dx = {1,-1,0,0};
    public static int N,M;
    public static String[] s;
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        s = new String[N];

        for(int i=0;i<N;i++)
            s[i] = br.readLine();

        List<int[]> crossArr = new ArrayList<>();
        boolean[][] checkArr = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(s[i].charAt(j) == '*'){
                    checkArr[i][j] = true;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(s[i].charAt(j) == '*'){
                    addCross(i,j,crossArr,checkArr);
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(checkArr[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(crossArr.size());
        crossArr.forEach(i->System.out.println((i[0]+1)+" "+(i[1]+1)+" "+i[2]));
    }

    private static void addCross(int i, int j, List<int[]> crossArr, boolean[][] checkArr) {
        int left_y =i;
        int left_x =j-1;

        int right_y =i;
        int right_x =j+1;

        int top_y = i-1;
        int top_x = j;

        int bottom_y =i+1;
        int bottom_x =j;

        int count = 1;
        while(checkIn(left_y,left_x)&& checkIn(right_y,right_x) && checkIn(top_y,top_x) && checkIn(bottom_y,bottom_x)){
            if(isStar(left_y,left_x)&& isStar(right_y,right_x) && isStar(top_y,top_x) && isStar(bottom_y,bottom_x)){
                crossArr.add(new int[]{i,j,count});
                checkArr[i][j] = false;
                checkArr[left_y][left_x] = false;
                checkArr[right_y][right_x] = false;
                checkArr[top_y][top_x] = false;
                checkArr[bottom_y][bottom_x] = false;

                left_x = left_x-1;
                right_x = right_x+1;
                top_y = top_y-1;
                bottom_y = bottom_y+1;
                count++;
            }
            else break;
        }
    }

    private static boolean isStar(int y, int x) {
        return s[y].charAt(x) == '*' ? true : false;
    }

    private static boolean checkIn(int y, int x) {
       if(y>=0 && x>= 0 && y<N && x<M) return true;
       else return false;
    }
}
