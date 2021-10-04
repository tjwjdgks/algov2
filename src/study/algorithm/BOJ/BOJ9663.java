package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백트래킹 고전 문제 N-Queen 재귀 공부
 */
public class BOJ9663 {
    public static int answer = 0;
    public static int N = 0;
    public static int [] stepArr;
    public static void dfs(int step){
        if(step == N){
            answer++;
            return;
        }
        for(int i=0;i<N;i++){
            stepArr[step] = i;
            if(checkArr(step)){
                dfs(step+1);
            }
        }
    }
    public static boolean checkArr(int step){
        for(int i=0;i<step;i++){
            if(stepArr[i] == stepArr[step] || (step - i) == Math.abs(stepArr[step] - stepArr[i]))
                return false;
        }
        return true;
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stepArr = new int[N];
        dfs(0);
        System.out.println(answer);
    }
}
