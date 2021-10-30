package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ16948 {
    public static int [] dy = {-2,-2,0,0,2,2};
    public static int [] dx = {-1,1,-2,2,-1,1};
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{arr[0],arr[1],0});
        int answer = -1;
        boolean [][] check = new boolean[N][N];
        check[arr[0]][arr[1]] = true;
        while(!queue.isEmpty()){
            int [] curpos = queue.poll();
            if(curpos[0] == arr[2] && curpos[1] == arr[3]){
                answer = curpos[2];
                break;
            }
            for(int i=0;i<6;i++){
                int tempy = curpos[0] + dy[i];
                int tempx = curpos[1] + dx[i];
                if(tempy>=0 && tempx>= 0 && tempy<N && tempx<N && !check[tempy][tempx]){
                    check[tempy][tempx] = true;
                    queue.add(new int[]{tempy,tempx,curpos[2]+1});
                }
            }
        }
        System.out.println(answer);
    }
}
