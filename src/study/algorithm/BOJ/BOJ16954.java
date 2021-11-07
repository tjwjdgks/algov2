package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class BOJ16954 {
    public static int [] dy = {-1,-1,-1,0,0,0,1,1,1};
    public static int [] dx = {-1,0,1,-1,0,1,-1,0,1};
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 8;
        String[] table = new String[N];
        for(int i=0;i<N;i++)
            table[i] = br.readLine();

        boolean [][][] check = new boolean [9][8][8];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{7,0,0});
        boolean flag = false;
        while(!queue.isEmpty()){
            int [] curidx = queue.poll();
            int curtime = curidx[2];
            if(curidx[0] == 0 && curidx[1] == 7){
                flag= true;
                break;
            }
            for(int i=0;i<9;i++){
                int tempy = curidx[0] + dy[i];
                int tempx = curidx[1] + dx[i];
                if(tempy>=0 && tempy<N && tempx>=0 && tempx<N){
                    if(check[curtime][tempy][tempx]) continue;
                    int blockIdx= tempy-curtime;
                    if((blockIdx>=0&&table[blockIdx].charAt(tempx)=='#') || (blockIdx-1>=0&&table[blockIdx-1].charAt(tempx)=='#')) continue;
                    int temptime = curtime+1;
                    if(temptime>=8)
                        temptime = 8;
                    check[curtime][tempy][tempx] = true;
                    queue.add(new int[]{tempy,tempx,temptime});
                }
            }
        }
        if(flag)
            System.out.println(1);
        else
            System.out.println(0);

    }
}
