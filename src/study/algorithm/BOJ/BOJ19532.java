package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] array = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        for(int i=0;i<=2000;i++){
            for(int j=0;j<=2000;j++){
                int x = i-1000;
                int y = j-1000;
                if(array[0]*x+array[1]*y == array[2] && array[3]*x+array[4]*y == array[5]){
                    System.out.println(x);
                    System.out.println(y);
                    return;
                }
            }
        }
    }
}
