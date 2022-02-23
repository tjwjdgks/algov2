package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1244 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalSwitches = Integer.parseInt(br.readLine());
        int[] switchArr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        int students = Integer.parseInt(br.readLine());
        for(int i =0;i<students;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int switchNum = Integer.parseInt(st.nextToken());
            if(gender == 1)
                doBoySwitch(switchArr,switchNum,totalSwitches);
            else
                doGirlSwitch(switchArr,switchNum,totalSwitches);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<totalSwitches;i++){
            if(i!=0 && i%20 ==0) sb.append("\n");
            sb.append(switchArr[i]+" ");
        }
        System.out.println(sb.toString());
    }

    private static void doGirlSwitch(int[] switchArr, int switchNum, int totalSwitches) {
        switchArr[switchNum-1] = changeSwitchStatus(switchArr[switchNum-1]);
        int switchLeft = switchNum-2;
        int switchRight = switchNum;
        while(switchLeft>=0 && switchRight<totalSwitches){
            if(switchArr[switchLeft] != switchArr[switchRight]) break;
            switchArr[switchLeft] = changeSwitchStatus(switchArr[switchLeft]);
            switchArr[switchRight] = changeSwitchStatus(switchArr[switchRight]);
            switchLeft--;
            switchRight++;
        }
    }

    private static void doBoySwitch(int[] switchArr, int switchNum, int totalSwitches) {
        int count = switchNum-1;
        while(count<totalSwitches){
            switchArr[count] = changeSwitchStatus(switchArr[count]);
            count += switchNum;
        }
    }
    private static int changeSwitchStatus(int num){
        return Math.abs(num-1);
    }
}
