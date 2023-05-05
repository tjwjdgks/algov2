package study.algorithm.study.dk.week13;

import java.util.Arrays;

public class Enzo {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int maxAlgo = 0;
        int maxCop = 0;
        for(int [] problem : problems){
            maxAlgo = Math.max(maxAlgo, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }
        int [][] dp = new int[maxAlgo+1][maxCop+1];
        for(int i=0;i<=maxAlgo;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE/2);
        }
        for(int i=0;i<=alp;i++){
            for(int j=0;j<=cop;j++){
                if(alp>maxAlgo) continue;
                if(cop>maxCop) continue;
                dp[i][j] = 0;
            }
        }
        for(int i=0;i<=maxAlgo;i++){
            for(int j=0;j<=maxCop;j++){
                if(i < maxAlgo){
                    dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]+1);
                }
                if(j < maxCop){
                    dp[i][j+1] = Math.min(dp[i][j+1],dp[i][j]+1);
                }
                for(int[] problem : problems){
                    if(problem[0]>i || problem[1]>j) continue;
                    int nextIndexI = i+problem[2] > maxAlgo ? maxAlgo : i+problem[2];
                    int nextIndexJ = j+problem[3] > maxCop ? maxCop : j+problem[3];
                    dp[nextIndexI][nextIndexJ] = Math.min(dp[nextIndexI][nextIndexJ],dp[i][j]+problem[4]);
                }
            }
        }
        return dp[maxAlgo][maxCop];
    }
    public static void main(String [] args){
        Enzo e = new Enzo();
        e.solution(	10, 10, new int[][]{{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}});
    }
}
