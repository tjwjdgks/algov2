package study.algorithm.BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ14225 {
    public static boolean [] totalArr = new boolean[20*100_000+1];
    public static int N;
    public static int [] numArr;
    public static void getCheck(int step, int sum){
        if(N == step){
            totalArr[sum] = true;
            return;
        }
        getCheck(step+1,sum+numArr[step]);
        getCheck(step+1,sum);
    }
    public static void getAnswer() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        getCheck(0,0);
        int answer = -1;
        for(int i=0;i< totalArr.length;i++){
            if(totalArr[i] == false){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
