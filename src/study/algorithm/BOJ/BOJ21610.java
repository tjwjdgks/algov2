package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21610 {
    public int N,M;
    public int [][] table;
    public int [][] orderArr;
    // y x
    public Queue<int[]> queue = new LinkedList<>();
    public int [] dy = {0,0,-1,-1,-1,0,1,1,1};
    public int [] dx = {0,-1,-1,0,1,1,1,0,-1};
    public boolean[][] check;
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        table = new int[N][N];
        check = new boolean[N][N];
        orderArr = new int[M][2];
        for(int i=0;i<N;i++){
            table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(num->Integer.parseInt(num)).toArray();
        }
        for(int i=0;i<M;i++){
            orderArr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(num->Integer.parseInt(num)).toArray();
        }
        init();
        for(int i=0;i<M;i++){
            doMove(orderArr[i][0],orderArr[i][1]);
            doRain();
            doCopy();
            doMakeCloud();
        }

        int totalWater = getTotalWater();
        System.out.println(totalWater);
    }

    private int getTotalWater() {
        int totalWater = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                totalWater += table[i][j];
            }
        }
        return  totalWater;
    }

    private void doMakeCloud() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(table[i][j] <2) continue;
                if(check[i][j]){
                    check[i][j] = false;
                    continue;
                }
                table[i][j] -=2;
                queue.add(new int[]{i,j});
            }
        }
    }

    private void doCopy() {
        while(!queue.isEmpty()){
            int [] curPos = queue.poll();
            int totalCopy = 0;
            for(int i=2;i<=8;i+=2){
                int tempy = curPos[0] + dy[i];
                int tempx = curPos[1] + dx[i];
                if(isIn(tempy,tempx) && table[tempy][tempx]>0) totalCopy++;
            }
            table[curPos[0]][curPos[1]] += totalCopy;
        }
    }
    private void doRain() {
        Queue<int[]> nextQueue = new LinkedList<>();
        while(!queue.isEmpty()){
            int[] curPos = queue.poll();
            table[curPos[0]][curPos[1]] +=1;
            check[curPos[0]][curPos[1]] = true;
            nextQueue.add(curPos);
        }
        queue = nextQueue;
    }


    private void doMove(int dir, int speed) {
        Queue<int[]> nextQueue = new LinkedList<>();
        while(!queue.isEmpty()){
            int[] curPos = queue.poll();
            int y = getPos(curPos[0] + dy[dir]*speed);
            int x = getPos(curPos[1] + dx[dir]*speed);
            nextQueue.add(new int[]{y,x});
        }
        queue = nextQueue;
    }

    private int getPos(int pos) {
        int nextPos = pos<0 ? N+(pos%N) : pos%N;
        return nextPos == N ? 0 : nextPos;
    }

    private void init() {
        queue.add(new int[]{N-1,0});
        queue.add(new int[]{N-1,1});
        queue.add(new int[]{N-2,0});
        queue.add(new int[]{N-2,1});
    }
    private boolean isIn(int y, int x) {
        return y>=0 && y<N && x>=0 && x<N;
    }
}
