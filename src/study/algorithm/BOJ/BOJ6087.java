package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ6087 {
    public static int [] dy = {0,1,0,-1};
    public static int [] dx = {1,0,-1,0};
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int [][] checkNum = new int[N][M];
        for(int i=0;i<N;i++)
            Arrays.fill(checkNum[i],Integer.MAX_VALUE/2);

        String[] s = new String[N];
        for(int i=0;i<N;i++)
            s[i] = br.readLine();

        int startx = -1,starty = -1;
        int endx = -1, endy = -1;

        boolean flag = false;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(s[i].charAt(j) == 'C'){
                    if(!flag){
                        flag = true;
                        starty = i;
                        startx = j;
                    }
                    else{
                        endy = i;
                        endx = j;
                    }
                }
            }
        }

        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            return o1[3]-o2[3];
        });
        int answer = 0;
        checkNum[starty][startx] = 0;
        for(int i=0;i<4;i++)
            queue.add(new int[]{starty,startx,i,0});

        while(!queue.isEmpty()){
            int [] curidx = queue.poll();
            if(curidx[0] == endy && curidx[1] == endx){
                answer = curidx[3];
                break;
            }
            for(int i=0;i<4;i++){
                int tempy = curidx[0] + dy[i];
                int tempx = curidx[1] + dx[i];
                if(tempy>=0 && tempx>=0 && tempy<N && tempx<M && s[tempy].charAt(tempx) != '*'){

                    if(i == curidx[2]){
                        if(checkNum[tempy][tempx]>=curidx[3]){
                            checkNum[tempy][tempx] = curidx[3];
                            queue.add(new int[]{tempy,tempx,i,curidx[3]});
                        }
                    }
                    else{
                        if(checkNum[tempy][tempx]>=curidx[3]+1){
                            checkNum[tempy][tempx] = curidx[3]+1;
                            queue.add(new int[]{tempy,tempx,i,curidx[3]+1});
                        }
                    }

                }
            }
        }
        System.out.println(answer);
    }
}
