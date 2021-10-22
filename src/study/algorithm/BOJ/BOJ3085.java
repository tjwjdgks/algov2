package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3085 {
    private static int [] dy = {0,0,1,-1};
    private static int [] dx = {1,-1,0,0};
    private static int N = 0;
    public static int searchCandy(char[][] candy, int y, int x){
        int maxNum=0;
        char standChar = candy[y][x];
        for(int i=0;i<2;i++){
            int tempy = y;
            int tempx = x;
            int tempTotal = 0;
            int idx = i*2;
            while(tempy>=0&&tempx>=0&&tempy<N&&tempx<N&&candy[tempy][tempx]==standChar){
                tempTotal++;
                tempy += dy[idx];
                tempx += dx[idx];
            }
            tempy = y;
            tempx = x;
            idx = i*2+1;
            while(tempy>=0&&tempx>=0&&tempy<N&&tempx<N&&candy[tempy][tempx]==standChar){
                tempTotal++;
                tempy += dy[idx];
                tempx += dx[idx];
            }
            maxNum = Math.max(tempTotal-1,maxNum);
        }
        return maxNum;
    }
    public static void swap(char[][] arr, int y, int x, int target_y, int target_x){
        char c = arr[y][x];
        arr[y][x] = arr[target_y][target_x];
        arr[target_y][target_x] = c;
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] candy = new char[N][];
        for(int i=0;i<N;i++)
            candy[i] = br.readLine().toCharArray();
        int answer = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                answer = Math.max(answer, searchCandy(candy,i,j));
                for(int k=0;k<4;k++){
                    int tempy = i+dy[k];
                    int tempx = j+dx[k];
                    if(tempy>=0 && tempx>= 0 && tempy<N&& tempx<N && candy[i][j] != candy[tempy][tempx]){
                        swap(candy,i,j,tempy,tempx);
                        answer = Math.max(searchCandy(candy,i,j),answer);
                        swap(candy,i,j,tempy,tempx);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
