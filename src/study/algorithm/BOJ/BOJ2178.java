package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2178 {
    public static int [] dy = {0,1,0,-1};
    public static int [] dx = {1,0,-1,0};
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] arr = new int[N][];
        for(int i=0;i<N;i++){
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(k->Integer.parseInt(k)).toArray();
        }
        LinkedList<int[]> queue = new LinkedList<>();
        int answer = -1;
        queue.add(new int[]{0,0,1});
        arr[0][0] = 0;
        while(!queue.isEmpty()){
            int []tempcord = queue.poll();
            if(tempcord[0] == N-1 && tempcord[1] == M-1){
                answer = tempcord[2];
                break;
            }
            for(int i=0;i<4;i++){
                int tempx = tempcord[0]+dx[i];
                int tempy = tempcord[1]+dy[i];
                if(tempx>=0 && tempy>=0 && tempx<N && tempy<M && arr[tempx][tempy] ==1){
                    arr[tempx][tempy] = 0;
                    queue.add(new int[]{tempx,tempy,tempcord[2]+1});
                }
            }
        }
        System.out.println(answer);
    }
}
