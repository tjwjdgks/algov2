package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15661 {
    private static int [][] tables;
    private static int N;
    private static int [] checks;
    private static int answer = Integer.MAX_VALUE;
    public static void dfs(int total,int start, int idx){
        if(total == start){
            int temp1 = 0;
            int temp2 = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j) continue;
                    if(checks[i] == 0 &&  checks[j] ==0){
                        temp1 += tables[i][j];
                    }
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j) continue;
                    if(checks[i] == 1 &&  checks[j] ==1){
                        temp2 += tables[i][j];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(temp1-temp2));
        }
        for(int i=idx+1;i<N;i++){
            checks[i] = 1;
            dfs(total,start+1,i);
            checks[i]=0;
        }
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tables = new int[N][];
        checks = new int[N];
        for(int i=0;i<N;i++){
            tables[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(k->Integer.parseInt(k)).toArray();
        }
        for(int i=1;i<=N/2;i++){
            dfs(i,0,-1);
            Arrays.fill(checks,0);
        }
        System.out.println(answer);
    }
}
