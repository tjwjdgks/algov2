package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17087 {
    public static int getGCD(int a, int b){
        if(b == 0)
            return a;
        else
            return getGCD(b,a%b);
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int [] numarr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        int [] gapArr = new int[N];
        for(int i=0; i<N; i++){
            gapArr[i] = Math.abs(numarr[i]- S);
        }
        if(N ==1){
            System.out.println(gapArr[0]);
            return;
        }
        int gcd =  -1;
        if(gapArr[0] > gapArr[1])
            gcd = getGCD(gapArr[0],gapArr[1]);
        else
            gcd = getGCD(gapArr[1],gapArr[0]);
        for(int i=2;i<N;i++){
            if(gcd>gapArr[i])
                gcd = getGCD(gcd,gapArr[i]);
            else
                gcd= getGCD(gapArr[i],gcd);
        }
        System.out.println(gcd);
    }
}
