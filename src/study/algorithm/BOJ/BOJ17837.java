package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17837 {
    public int [] dy = {0,0,-1,1,0};
    public int [] dx = {1,-1,0,0,0};
    public int [][] map;
    public int [][] play;
    public int N,M;
    public Stack<Integer>[][] stackMap;
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][];
        for(int i=0;i<N;i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        }
        stackMap = new Stack[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                stackMap[i][j] = new Stack<>();
            }
        }
        play = new int[M][];
        for(int i=0;i<M;i++){
            play[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)-1).toArray();
            stackMap[play[i][0]][play[i][1]].push(i);
        }
        int count = 0;
        while(count<1000){
            count++;
            for(int i=0;i<M;i++){
                int dirIndex = play[i][2];
                int nextPlayY = play[i][0] + dy[dirIndex];
                int nextPlayX = play[i][1] + dx[dirIndex];
                if(!isPossible(nextPlayY,nextPlayX) || map[nextPlayY][nextPlayX] == 2){
                    doBlue(i,play[i][0],play[i][1],play[i][2]);
                }
                else if(map[nextPlayY][nextPlayX] == 1){
                    doRed(i,play[i][0],play[i][1],play[i][2]);
                }
                else if(map[nextPlayY][nextPlayX] == 0){
                    doWhite(i,play[i][0],play[i][1],play[i][2]);
                }
                if(stackMap[play[i][0]][play[i][1]].size()>=4){
                    System.out.println(count);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    public void doWhite(int index,int y, int x, int dir){
        int nextY = y + dy[dir];
        int nextX = x + dx[dir];
        Stack<Integer> tempStack = new Stack<>();
        while(stackMap[y][x].peek() != index){
            int nextIndex = stackMap[y][x].pop();
            play[nextIndex][0] = nextY;
            play[nextIndex][1] = nextX;
            tempStack.push(nextIndex);
        }
        tempStack.push(stackMap[y][x].pop());
        while(!tempStack.isEmpty()){
            stackMap[nextY][nextX].push(tempStack.pop());
        }
        play[index][0] = nextY;
        play[index][1] = nextX;
    }
    public void doRed(int index,int y, int x, int dir){
        int nextY = y + dy[dir];
        int nextX = x + dx[dir];
        while(stackMap[y][x].peek()!= index){
            int nextIndex = stackMap[y][x].pop();
            play[nextIndex][0] = nextY;
            play[nextIndex][1] = nextX;
            stackMap[nextY][nextX].push(nextIndex);
        }
        stackMap[nextY][nextX].push(stackMap[y][x].pop());
        play[index][0] = nextY;
        play[index][1] = nextX;
    }
    public void doBlue(int index,int y, int x, int dir){
        int reverseDir = switchDir(dir);
        int nextY = y + dy[reverseDir];
        int nextX = x + dx[reverseDir];
        play[index][2] = reverseDir;
        if(!isPossible(nextY,nextX) || map[nextY][nextX] == 2){
            return;
        }
        if(map[nextY][nextX] == 0)
            doWhite(index,y,x,reverseDir);
        else if(map[nextY][nextX] == 1)
            doRed(index,y,x,reverseDir);
    }
    public int switchDir(int dir){
        return dir%2 == 0 ? dir+1 : dir-1;
    }
    public boolean isPossible(int y, int x){
        return y>=0 && x>=0 && y<N && x<N;
    }
}
