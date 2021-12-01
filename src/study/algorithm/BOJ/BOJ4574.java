package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ4574 {
    public static final int SIZE = 9;
    public static int [][] map = new int[SIZE][SIZE];
    public static boolean [][] checkRow = new boolean[SIZE][SIZE+1];
    public static boolean [][] checkCol = new boolean[SIZE][SIZE+1];
    public static boolean [][][] checkBox = new boolean[SIZE/3][SIZE/3][SIZE+1];
    public static boolean [][] checkNum = new boolean[SIZE+1][SIZE+1];
    public static boolean flag = false;
    public static StringBuffer sb = new StringBuffer();
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        int count = 0;
        while((N = Integer.parseInt(br.readLine())) != 0){
            init();
            count++;
            for(int i=0;i<N;i++){
                String [] tempArr = br.readLine().split(" ");
                int num = Integer.parseInt(tempArr[0]);
                int num2 = Integer.parseInt(tempArr[2]);
                checkInput(num,tempArr[1]);
                checkInput(num2,tempArr[3]);
                checkNum[num][num2] = true;
                checkNum[num2][num] = true;
            }
            String [] oneNum = br.readLine().split(" ");
            for(int i=0;i<SIZE;i++){
                checkInput(i+1,oneNum[i]);
            }
            sb.append("Puzzle ").append(count).append("\n");
            dfs(0);
        }
    }
    public static void checkInput(int num, String idx){
        int row = idx.charAt(0)-'A';
        int col = idx.charAt(1)-'1';
        map[row][col] = num;
        checkRow[row][num] = true;
        checkCol[col][num] = true;
        checkBox[row/3][col/3][num] = true;
    }
    public static void init(){
        flag = false;
        sb.setLength(0);
        for(int i=0;i<SIZE;i++){
            Arrays.fill(map[i],0);
            Arrays.fill(checkCol[i],false);
            Arrays.fill(checkRow[i],false);
        }
        for(int i=0;i<SIZE+1;i++)
            Arrays.fill(checkNum[i],false);
        for(int i=0;i<SIZE/3;i++)
            for(int j=0;j<SIZE/3;j++)
                for(int k=0;k<SIZE+1;k++)
                    checkBox[i][j][k]= false;
    }
    public static void print(){
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                sb.append(map[i][j]);
            }
            if(i!=SIZE-1)
                sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void checking(int y,int x, int y2, int x2,int num1, int num2,boolean flag){
        if(flag){
            map[y][x]= num1;
            map[y2][x2] = num2;
        }
        else{
            map[y][x]= 0;
            map[y2][x2] = 0;
        }
        checkRow[y][num1] = flag;
        checkRow[y2][num2] = flag;
        checkCol[x][num1] = flag;
        checkCol[x2][num2] = flag;
        checkBox[y/3][x/3][num1] = flag;
        checkBox[y2/3][x2/3][num2] = flag;
        checkNum[num1][num2] = flag;
        checkNum[num2][num1] = flag;
    }
    // true 세로 false 가로
    public static boolean isFit(int y, int x, int y2, int x2, int num1,int num2){
       return !checkCol[x][num1] && !checkCol[x2][num2] && !checkRow[y][num1]
               && !checkRow[y2][num2] && !checkBox[y/3][x/3][num1] && !checkBox[y2/3][x2/3][num2];
    }
    public static void dfs(int step){
        if(flag) return;
        if(step == 81){
            print();
            flag= true;
            return;
        }
        int y = step/SIZE;
        int x = step%SIZE;
        if(map[y][x] !=0) dfs(step+1);
        else{
            if(y<8 && map[y+1][x] == 0){
                for(int i=1;i<SIZE+1;i++){
                    for(int j=i+1;j<SIZE+1;j++){
                        if(checkNum[i][j]) continue;
                        if(isFit(y,x,y+1,x,i,j)){
                            checking(y,x,y+1,x,i,j,true);
                            dfs(step+1);
                            checking(y,x,y+1,x,i,j,false);
                        }
                        if(isFit(y,x,y+1,x,j,i)){
                            checking(y,x,y+1,x,j,i,true);
                            dfs(step+1);
                            checking(y,x,y+1,x,j,i,false);
                        }
                    }
                }
            }
            if(x<8 && map[y][x+1] == 0){
                for(int i=1;i<SIZE+1;i++){
                    for(int j=i+1;j<SIZE+1;j++){
                        if(checkNum[i][j]) continue;
                        if(isFit(y,x,y,x+1,i,j)){
                            checking(y,x,y,x+1,i,j,true);
                            dfs(step+1);
                            checking(y,x,y,x+1,i,j,false);
                        }
                        if(isFit(y,x,y,x+1,j,i)){
                            checking(y,x,y,x+1,j,i,true);
                            dfs(step+1);
                            checking(y,x,y,x+1,j,i,false);
                        }
                    }
                }
            }
        }
    }

}
