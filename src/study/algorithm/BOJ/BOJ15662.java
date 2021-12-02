package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15662 {
    public static int [][] gears;
    public static int [] gearsHead;
    public static void rotate(int idx,int clock){
        change(idx,clock);
        int leftclock = clock;
        int rightclock = clock;
        for(int i= idx;i>=1;i--){
            int preNum = getIdx(gearsHead[i],-leftclock);
            if(gears[i-1][getIdx(gearsHead[i-1],2)] != gears[i][getIdx(preNum,6)]){
                change(i-1,-leftclock);
                leftclock = -leftclock;
            }
            else break;
        }
        for(int i= idx;i<gears.length-1;i++){
            int preNum = getIdx(gearsHead[i],-rightclock);
            if(gears[i+1][getIdx(gearsHead[i+1],6)] != gears[i][getIdx(preNum,2)]){
                change(i+1,-rightclock);
                rightclock = -rightclock;
            }
            else break;
        }
    }
    public static int getIdx(int idx, int num){
        int curidx = idx+num;
        if(curidx<0)
            return 8-Math.abs(curidx);
        if(curidx>7)
            return curidx%8;
        return curidx;
    }
    public static void change(int idx,int clock){
        gearsHead[idx] = getIdx(gearsHead[idx],clock);
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        gears = new int[T][];
        gearsHead = new int[T];
        for(int i=0;i<T;i++)
            gears[i] = Arrays.stream(br.readLine().split("")).mapToInt(num->Integer.parseInt(num)).toArray();

        int R = Integer.parseInt(br.readLine());
        for(int i=0;i<R;i++){
            String [] s = br.readLine().split(" ");
            int idx = Integer.parseInt(s[0])-1;
            int clock = Integer.parseInt(s[1]);
            rotate(idx,-clock);
        }
        int answer = 0;
        for(int i=0;i<T;i++){
            if(gears[i][gearsHead[i]] == 1) answer++;
        }
        System.out.println(answer);
    }
}
