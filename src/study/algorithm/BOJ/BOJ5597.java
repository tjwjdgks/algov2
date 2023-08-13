package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5597 {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] checked = new boolean[30];
        for(int i=0;i<28;i++){
            int n = Integer.parseInt(br.readLine())-1;
            checked[n]= true;
        }
        for(int i=0;i<30;i++){
            if(!checked[i]) System.out.println(i+1);
        }
    }
}
