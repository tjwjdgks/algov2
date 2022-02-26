package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ2578 {
    public static void getAnswer() {
        Scanner scanner = new Scanner(System.in);
        int arr[][] = new int[25][2];
        boolean check[][] = new boolean[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                int N = scanner.nextInt()-1;
                arr[N][0] = i;
                arr[N][1] = j;
            }
        }
        boolean flag=  false;
        int count = 1;
        int answer = -1;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                int N = scanner.nextInt()-1;
                check[arr[N][0]][arr[N][1]] = true;
                if(flag) continue;
                if(isBingo(check)){
                    flag= true;
                    answer = count;
                }
                count++;
            }
        }
        System.out.println(answer);
    }

    private static boolean isBingo(boolean[][] check) {
        int bingoRowNum = 0;
        for(int i=0;i<5;i++){
            if(row(check,i)) bingoRowNum++;
            if(col(check, i)) bingoRowNum++;
        }
        if(crossRight(check)) bingoRowNum++;
        if(crossLeft(check)) bingoRowNum++;


        if(bingoRowNum>=3) return true;
        else return false;
    }

    private static boolean crossLeft(boolean[][] check) {
        boolean flag= true;
        for(int i=0;i<5;i++){
            if(!check[i][4-i]){
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static boolean crossRight(boolean[][] check) {
        boolean flag = true;
        for(int i=0;i<5;i++){
            if(!check[i][i]){
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static boolean col(boolean[][] check, int i) {
        boolean flag= true;
        for(int j=0;j<5;j++){
            if(!check[j][i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static boolean row(boolean[][] check, int i) {
        boolean flag= true;
        for(int j=0;j<5;j++){
            if(!check[i][j]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
