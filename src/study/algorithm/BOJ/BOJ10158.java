package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10158 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        int afterX = getIndex(w,x,t);
        int afterY = getIndex(h,y,t);
        System.out.println(afterX + " "+afterY);
    }

    private static int getIndex(int length, int cord, int time) {
        int rest = time%(length*2);
        int first = length-cord;
        if(rest<=first){
            return cord + rest;
        }
        rest -= first;
        if(rest<=length){
            return length - rest;
        }
        rest -= length;
        return rest;
    }
}
