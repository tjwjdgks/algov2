package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ16198 {
    public static int N;
    public static int [] numArr;
    public static boolean [] checkArr;
    public static int maxNum = 0;
    public static void dfs(int step, int sum){
        if(step ==0){
            maxNum = Math.max(sum,maxNum);
            return;
        }
        for(int i=1;i<N-1;i++){
            if(checkArr[i]) continue;
            checkArr[i] = true;
            int firstnum=0, secondnum=0;
            for(int j=i-1;j>=0;j--){
                if(checkArr[j]== false){
                    firstnum = numArr[j];
                    break;
                }
            }
            for(int j=i+1;j<N;j++){
                if(checkArr[j] == false){
                    secondnum = numArr[j];
                    break;
                }
            }
            dfs(step-1,sum+firstnum*secondnum);
            checkArr[i] = false;
        }
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(k->Integer.parseInt(k)).toArray();
        checkArr = new boolean[N];
        dfs(N-2,0);
        System.out.println(maxNum);
    }
}
