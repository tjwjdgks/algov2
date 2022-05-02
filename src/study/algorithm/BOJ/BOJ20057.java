package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20057 {
    public int[] dy = {-1,-1,0,1,1,1,0,-1};
    public int[] dx = {0,1,1,1,0,-1,-1,-1};
    public Queue<int[]> [][] startQueue;
    public Queue<int[]> [][] endQueue;
    public int N,M,K;
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        startQueue = new Queue[N][N];
        endQueue = new Queue[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                startQueue[i][j] = new LinkedList<>();
                endQueue[i][j] = new LinkedList<>();
            }
        }
        // int [] 질량, 속력, 방향
        for(int i=0;i<M;i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(num->Integer.parseInt(num)).toArray();
            startQueue[arr[0]-1][arr[1]-1].add(new int[]{arr[2],arr[3],arr[4]});
        }
        for(int i=0;i<K;i++){
            doStart();
            doMerge();
        }
        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                while(!startQueue[i][j].isEmpty()){
                    answer += startQueue[i][j].poll()[0];
                }
            }
        }
        System.out.println(answer);
    }

    private void doMerge() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(endQueue[i][j].isEmpty()) continue;
                if(endQueue[i][j].size()<2) {
                    startQueue[i][j].add(endQueue[i][j].poll());
                   continue;
                }
                int totalSize = endQueue[i][j].size();
                int totalM = 0;
                int totalS = 0;
                // 짝수 // 홀수 // 혼합
                int dirFlag = -1;
                while(!endQueue[i][j].isEmpty()){
                    int[] curBall = endQueue[i][j].poll();
                    totalM += curBall[0];
                    totalS += curBall[1];
                    if(dirFlag == -1){
                        if(curBall[2]%2 == 0) dirFlag = 0;
                        else dirFlag =1;
                    }
                    else{
                        if(dirFlag == 2) continue;
                        if(curBall[2]%2 != dirFlag) dirFlag = 2;
                    }
                }
                int curM  = totalM/5;
                int curS = totalS/totalSize;
                if(curM !=0){
                    if(dirFlag != 2 ){
                        for(int k=0;k<4;k++){
                            startQueue[i][j].add(new int[]{curM,curS,k*2});
                        }
                    }
                    else{
                        for(int k=0;k<4;k++){
                            startQueue[i][j].add(new int[]{curM,curS,k*2+1});
                        }
                    }
                }
            }
        }
    }

    private void doStart() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                while(!startQueue[i][j].isEmpty()){
                    int[] curBall = startQueue[i][j].poll();
                    int[] nextDir = getDest(i+curBall[1]*dy[curBall[2]],j+curBall[1]*dx[curBall[2]]);
                    endQueue[nextDir[0]][nextDir[1]].add(curBall);
                }
            }
        }
    }

    public int[] getDest(int y, int x){
        int[] nextDest = new int[2];
        nextDest[0] = y<0 ? N+(y%N) : y%N;
        nextDest[0] = nextDest[0] == N ? 0 : nextDest[0];
        nextDest[1] = x<0 ? N+(x%N) : x%N;
        nextDest[1] = nextDest[1] == N ? 0 : nextDest[1];

        return nextDest;
    }
}
