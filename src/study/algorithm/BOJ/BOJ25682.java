package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] s = new String[N];
        for(int i=0;i<N;i++){
            s[i] = br.readLine();
        }
        // 0 검정 시작 1 흰색 시작
        int [][][] sumTable = new int[N][M][2];

        if(s[0].charAt(0) == 'B'){
            sumTable[0][0][0] = 0;
            sumTable[0][0][1] = 1;
        }
        else{
            sumTable[0][0][0] = 1;
            sumTable[0][0][1] = 0;
        }
        for(int i=1;i<N;i++){
            if(i%2==0 && s[i].charAt(0) == 'B'){
                sumTable[i][0][0] = sumTable[i-1][0][0];
                sumTable[i][0][1] = sumTable[i-1][0][1]+1;
            }
            else if(i%2==0 && s[i].charAt(0) == 'W'){
                sumTable[i][0][0] = sumTable[i-1][0][0]+1;
                sumTable[i][0][1] = sumTable[i-1][0][1];
            }
            else if(i%2==1 && s[i].charAt(0) == 'B'){
                sumTable[i][0][0] = sumTable[i-1][0][0]+1;
                sumTable[i][0][1] = sumTable[i-1][0][1];
            }
            else{
                sumTable[i][0][0] = sumTable[i-1][0][0];
                sumTable[i][0][1] = sumTable[i-1][0][1]+1;
            }
        }
        for(int i=1;i<M;i++){
            if(i%2==0 && s[0].charAt(i) == 'B'){
                sumTable[0][i][0] = sumTable[0][i-1][0];
                sumTable[0][i][1] = sumTable[0][i-1][1]+1;
            }
            else if(i%2==0 && s[0].charAt(i) == 'W'){
                sumTable[0][i][0] = sumTable[0][i-1][0]+1;
                sumTable[0][i][1] = sumTable[0][i-1][1];
            }
            else if(i%2==1 && s[0].charAt(i) == 'B'){
                sumTable[0][i][0] = sumTable[0][i-1][0]+1;
                sumTable[0][i][1] = sumTable[0][i-1][1];
            }
            else{
                sumTable[0][i][0] = sumTable[0][i-1][0];
                sumTable[0][i][1] = sumTable[0][i-1][1]+1;
            }
        }
        for(int i=1;i<N;i++){
            for(int j=1; j<M;j++){
                if((i+j)% 2 == 0 && s[i].charAt(j) == 'B'){
                    sumTable[i][j][0] = sumTable[i-1][j][0] + sumTable[i][j-1][0] - sumTable[i-1][j-1][0];
                    sumTable[i][j][1] = sumTable[i-1][j][1] + sumTable[i][j-1][1] - sumTable[i-1][j-1][1]+1;
                }
                else if((i+j)% 2 == 0 && s[i].charAt(j) == 'W'){
                    sumTable[i][j][0] = sumTable[i-1][j][0] + sumTable[i][j-1][0] - sumTable[i-1][j-1][0]+1;
                    sumTable[i][j][1] = sumTable[i-1][j][1] + sumTable[i][j-1][1] - sumTable[i-1][j-1][1];
                }
                else if((i+j)% 2 == 1 && s[i].charAt(j) == 'B'){
                    sumTable[i][j][0] = sumTable[i-1][j][0] + sumTable[i][j-1][0] - sumTable[i-1][j-1][0]+1;
                    sumTable[i][j][1] = sumTable[i-1][j][1] + sumTable[i][j-1][1] - sumTable[i-1][j-1][1];
                }
                else{
                    sumTable[i][j][0] = sumTable[i-1][j][0] + sumTable[i][j-1][0] - sumTable[i-1][j-1][0];
                    sumTable[i][j][1] = sumTable[i-1][j][1] + sumTable[i][j-1][1] - sumTable[i-1][j-1][1]+1;
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i=K-1;i<N;i++){
            for(int j=K-1;j<M;j++){
                int sum1 = sumTable[i][j][0];
                int sum2 = sumTable[i][j][1];
                if(i>K-1){
                    sum1 -= sumTable[i-K][j][0];
                    sum2 -= sumTable[i-K][j][1];
                }
                if(j>K-1){
                    sum1 -= sumTable[i][j-K][0];
                    sum2 -= sumTable[i][j-K][1];
                }
                if(i>K-1 && j>K-1){
                    sum1 += sumTable[i-K][j-K][0];
                    sum2 += sumTable[i-K][j-K][1];
                }
                answer = Math.min(answer, Math.min(sum1,sum2));
            }
        }
        System.out.println(answer);
    }

}
