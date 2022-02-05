package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ17825 {
    public static int answer = 0;
    public static int []diceArr = new int[10];
    public static int []selectOrder = new int[10];
    // 1~ 4 까지
    public static int [][]horseIndex = new int[5][2];
    public static int [][] map = new int[][]{
            {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40},
            {10,13,16,19,25},
            {20,22,24,25},
            {30,28,27,26,25},
            {40},
            {25,30,35,40},
    };
    public static void roll(int step){
        if(step == 10){
            answer = Math.max(play(), answer);
            return;
        }
        for(int i=1;i<=4;i++){
            selectOrder[step] = i;
            roll(step+1);
        }
    }
    // hourse 0 : step 1 : pos 2 : \
    private static int play() {
        init();
        int count = 0;
        for(int i=0;i<diceArr.length;i++){
            int curHorse = selectOrder[i];
            int curStep = horseIndex[curHorse][0];
            int curPos = horseIndex[curHorse][1] + diceArr[i];


            if(curPos<map[curStep].length){
                if(curStep == 0 && map[curStep][curPos]%10 == 0 ){
                    curStep = map[curStep][curPos]/10;
                    curPos = 0;
                }
                if(curStep == 5 && map[curStep][curPos] == 40){
                    curStep = map[curStep][curPos]/10;
                    curPos = 0;
                }
                if(map[curStep][curPos] == 25 && curPos == map[curStep].length-1){
                    curStep = 5;
                    curPos =0;
                }
                for(int j=1;j<=4;j++){
                    if(j == curHorse) continue;
                    if(horseIndex[j][0] == curStep && horseIndex[j][1] == curPos) return 0;
                }
                horseIndex[curHorse][0] = curStep;
                horseIndex[curHorse][1] = curPos;
                count += map[curStep][curPos];
            }
            else{
                horseIndex[curHorse][1] = curStep;

                if((curStep == 1 || curStep == 2 || curStep ==3) && curPos-map[curStep].length+1<map[5].length){
                    curPos = curPos - map[curStep].length+1;
                    curStep =5;
                    if(curStep == 5 && map[curStep][curPos] == 40){
                        curStep = map[curStep][curPos]/10;
                        curPos = 0;
                    }
                    for(int j=1;j<=4;j++){
                        if(j == curHorse) continue;
                        if(horseIndex[j][0] == curStep && horseIndex[j][1] == curPos) return 0;
                    }
                    horseIndex[curHorse][0] = curStep;
                    horseIndex[curHorse][1] = curPos;
                    count += map[curStep][curPos];
                }
            }
        }
        return count;
    }

    private static void init() {
        for(int i=0;i<horseIndex.length;i++)
            Arrays.fill(horseIndex[i],0);
    }

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        diceArr= Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        roll(0);
        System.out.println(answer);
    }
}
