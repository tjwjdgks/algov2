package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11758 {

    // s2-s1 dot s3-s2
    //  == 0 일직선
    // <0 반시계
    // 0> 시계
    // ad - bc
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1X = Integer.parseInt(st.nextToken());
        int p1Y = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p2X = Integer.parseInt(st.nextToken());
        int p2Y = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p3X = Integer.parseInt(st.nextToken());
        int p3Y = Integer.parseInt(st.nextToken());
        int dot = (p2X-p1X)*(p3Y-p1Y) - (p2Y-p1Y)*(p3X-p1X);
        if(dot>0){
            System.out.println(1);
        }
        else if(dot ==0){
            System.out.println(0);
        }
        else{
            System.out.println(-1);
        }

    }
}
