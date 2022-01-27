package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ17779 {
    public static int[][] dp;
    public static int[][] table;
    public static void getAnswer() throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        table = new int[N][];
        for(int i=0;i<table.length;i++){
            table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(k->Integer.parseInt(k)).toArray();
        }
        getTotalTable(N);

        int minNum = Integer.MAX_VALUE;
        for(int posY=0;posY<N;posY++){
            for(int posX=0;posX<N;posX++){
                for(int y=1;y<N;y++){
                    for(int x=1;x<N;x++){
                       minNum = Math.min(minNum,getArea(N,posX,posY,y,x));
                    }
                }
            }
        }
        System.out.println(minNum);
    }

    private static int getArea(int N, int posX, int posY, int y, int x) {
        int area1 =0;
        int area2 =0;
        int area3 =0;
        int area4 =0;
        int area5 =0;

        int rightYCount =0;
        int leftYCount = 0;

        int leftXPos =posX-1;
        int rightXPos =posX+1;

        for(int i=0;i<N;i++){
            if(i<posY){
                area1 += getCal(N,i,-1,posX);
                area2 += getCal(N,i,posX,N-1);
            }
            else if(i>posY+y+x){
                area3 += getCal(N,i,-1,leftXPos-1);
                area4 += getCal(N,i,rightXPos-1,N-1);
            }
            else{
                if(leftYCount<y){
                    area1 += getCal(N,i,-1,leftXPos);
                }
                else{
                    area3 += getCal(N,i,-1,leftXPos);
                }
                if(rightYCount<=x){
                    area2 += getCal(N,i,rightXPos-1,N-1);
                }
                else{
                    area4 += getCal(N,i,rightXPos-1,N-1);
                }
                area5 += getCal(N,i,leftXPos,rightXPos-1);


                leftXPos = leftYCount<y ? --leftXPos : ++leftXPos;
                rightXPos = rightYCount<x ? ++rightXPos : --rightXPos;

                leftYCount++;
                rightYCount++;
            }
        }
        List<Integer> area = Arrays.asList(area1, area2, area3, area4, area5);
        Collections.sort(area);
        return area.get(area.size()-1) - area.get(0);
    }

    private static int getCal(int N,int y, int start, int end) {
        int startTotal;
        if(start<0){
            startTotal  = 0;
        }
        else if(start>=N){
            startTotal = dp[y][N-1];
        }
        else{
            startTotal = dp[y][start];
        }
        int endTotal;
        if(end<0){
            endTotal  = 0;
        }
        else if(end>=N){
            endTotal = dp[y][N-1];
        }
        else{
            endTotal = dp[y][end];
        }
        return endTotal - startTotal;
    }


    private static void getTotalTable(int N) {
        dp = new int[N][N];
        for(int i =0;i<N;i++){
            for(int j=0;j<N;j++){
                if(j==0){
                    dp[i][j] = table[i][j];
                }
                else{
                    dp[i][j] = dp[i][j-1] +table[i][j];
                }
            }
        }
    }
}
