package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ2580 {

    public static int[][] arr = new int[9][9];
    public static int[][] answer = new int[9][9];

    public static boolean flag = false;

    public static void doGame(int rest, int y, int x){
        if(flag) return;
        if(rest == 0){
            flag = true;
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    answer[i][j] = arr[i][j];
                }
            }
            return;
        }
        for(int i=y;i<9;i++){
            for(int j=x; j<9;j++){
                if(arr[i][j] == 0){
                    for(int k=1;k<=9;k++){
                        if(possibleRow(i,j,k) && possibleCol(i,j,k) && possibleArea(i,j,k)){
                            arr[i][j] = k;
                            doGame(rest-1, y, x);
                            arr[i][j] = 0;
                        }

                    }
                    return;
                }
            }
        }

    }

    private static boolean possibleRow(int y, int x, int k) {
        for(int i=0;i<9;i++){
            if(arr[y][i] == k) return false;
        }
        return true;
    }
    private static boolean possibleCol(int y, int x, int k) {
        for(int i=0;i<9;i++){
            if(arr[i][x] == k) return false;
        }
        return true;
    }
    private static boolean possibleArea(int y, int x, int k) {
        int startY = (y/3)*3;
        int startX = (x/3)*3;
        for(int i=startY;i<startY+3;i++){
            for(int j=startX; j<startX+3; j++){
                if(arr[i][j] == k) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<9;i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        }
        int zeroCount = 0;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(arr[i][j] == 0) zeroCount++;
            }
        }
        doGame(zeroCount,0,0);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<9;i++){
            String s= Arrays.stream(answer[i]).mapToObj(n->String.valueOf(n)).collect(Collectors.joining(" "));
            sb.append(s).append("\n");
        }
        System.out.print(sb.toString());
    }
}
