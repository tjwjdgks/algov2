package study.algorithm.PROGRAMMERS.kakao2022;

import java.util.ArrayList;
import java.util.List;

public class six {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int amos[][] = new int[board.length+1][board[0].length+1];

        for(int [] i : skill){
            if(i[0] ==1){
                amos[i[1]][i[2]] += -i[5];
                amos[i[1]][i[4]+1] += i[5];
                amos[i[3]+1][i[2]] += i[5];
                amos[i[3]+1][i[4]+1] += -i[5];
            }
            else{
                amos[i[1]][i[2]] += i[5];
                amos[i[1]][i[4]+1] += -i[5];
                amos[i[3]+1][i[2]] += -i[5];
                amos[i[3]+1][i[4]+1] += i[5];
            }
        }
        for(int i=0;i<amos.length;i++){
            int num = 0;
            for(int j=0;j<amos[0].length;j++){
                num += amos[i][j];
                amos[i][j] = num;
            }
        }
        for(int i=0;i<amos[0].length;i++){
            int num = 0;
            for(int j=0;j<amos.length;j++){
                num += amos[j][i];
                amos[j][i] = num;
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j< board[0].length;j++){
                if(board[i][j]+amos[i][j]>0){
                    answer++;
                }
            }
        }
        return answer;
    }
}
