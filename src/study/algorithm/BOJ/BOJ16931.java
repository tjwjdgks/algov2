package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16931 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] tables = new int[N][];
        for(int i=0;i<N;i++)
            tables[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(num->Integer.parseInt(num)).toArray();

        int down  = N*M;
        int leftSide = 0;
        int rightSide = 0;

        for(int i=0;i<N;i++){
            for(int j = 0;j<M;j++){
                if(j == 0){
                    leftSide += tables[i][j];
                }
                else{
                    if(tables[i][j-1]<tables[i][j])
                        leftSide+= tables[i][j] - tables[i][j-1];
                }
            }
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(j == 0){
                    rightSide += tables[j][i];
                }
                else{
                    if(tables[j-1][i]<tables[j][i])
                        rightSide+= tables[j][i] - tables[j-1][i];
                }
            }
        }
        System.out.println(2*down+2*leftSide+2*rightSide);
    }
}
