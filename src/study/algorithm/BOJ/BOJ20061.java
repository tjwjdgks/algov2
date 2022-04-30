package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class BOJ20061 {
    public int N;
    public boolean[][] table = new boolean[10][10];
    public final int MAX = 10;
    public int count = 0;
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(num->Integer.parseInt(num)).toArray();
            int type = nums[0];
            int y = nums[1];
            int x = nums[2];
            startGreen(y,x,type);
            startBlue(y,x,type);
        }
        int checkCount = 0;
        for(int i=4;i<MAX;i++) {
            for(int j=0;j<4;j++) {
                if(table[j][i] == true) checkCount++;
            }
        }
        for(int i=4;i<MAX;i++) {
            for(int j=0;j<4;j++) {
                if(table[i][j]==true) checkCount++;
            }
        }
        System.out.println(count);
        System.out.println(checkCount);
    }
    private void startBlue(int y, int x, int type) {
        if(type == 1) type1(y,x,true);
        else if(type == 2) type2(y,x,true);
        else if(type == 3) type3(y,x,true);
        for(int j = 4;j<MAX;j++) {
            if(isAll(j,true)) {
                count++;
                remove(j,true);
            }
        }
        for(int j=4;j<=5;j++) {
            for(int k=0;k<4;k++) {
                if(table[k][j]==true) {
                    remove(MAX-1,true);
                    break;
                }
            }
        }
    }
    private void startGreen(int y, int x, int type) {
        if(type == 1) type1(y,x,false);
        else if(type == 2) type3(y,x,false);
        else if(type == 3) type2(y,x,false);
        for(int j=4;j<MAX;j++) {
            if(isAll(j,false)) {
                count++;
                remove(j,false);
            }
        }
        for(int j=4;j<=5;j++) {
            for(int k=0;k<4;k++) {
                if(table[j][k] == true) {
                    remove(MAX-1,false);
                    break;
                }
            }
        }
    }
    private void remove(int j, boolean flag) {
        if(flag) {
            for(int i=j;i>=5;i--) {
                for(int k=0;k<4;k++) {
                    table[k][i] = table[k][i-1];
                }
            }
            for(int k=0;k<4;k++) {
                table[k][4] = false;
            }

        }
        else {
            for(int i=j;i>=5;i--) {
                for(int k=0;k<4;k++) {
                    table[i][k] = table[i-1][k];
                }
            }
            for(int k=0;k<4;k++) {
                table[4][k] = false;
            }
        }

    }
    private boolean isAll(int j,boolean flag) {
        // TODO Auto-generated method stub
        if(flag) {
            for(int i=0;i<4;i++) {
                if(table[i][j]==false) return false;
            }
            return true;
        }
        else {
            for(int i=0;i<4;i++) {
                if(table[j][i] == false) return false;
            }
            return true;
        }
    }
    private void type1(int y, int x,boolean flag) {
        if(flag) {
            while(x+1<MAX && table[y][x+1]!=true) {
                x++;
            }
        }
        else {
            while(y+1<MAX && table[y+1][x]!=true) {
                y++;
            }
        }
        table[y][x] = true;
    }
    private void type2(int y, int x, boolean flag) {
        if(flag) {
            while(x+2<MAX && table[y][x+2]!= true) {
                x++;
            }
            table[y][x+1] = true;
            table[y][x] = true;
        }
        else {
            while(y+2<MAX && table[y+2][x]!= true) {
                y++;
            }
            table[y+1][x] = true;
            table[y][x] = true;
        }
    }
    private void type3(int y, int x, boolean flag) {
        if(flag) {
            while(x+1<MAX && table[y][x+1]!=true && table[y+1][x+1]!=true) {
                x++;
            }
            table[y][x] = true;
            table[y+1][x] = true;
        }
        else {
            while(y+1<MAX && table[y+1][x]!=true && table[y+1][x+1]!=true) {
                y++;
            }
            table[y][x] = true;
            table[y][x+1] = true;
        }
    }
}