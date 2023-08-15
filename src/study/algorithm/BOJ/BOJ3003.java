package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ3003 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] curArray = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        int [] resultArray = new int[]{1,1,2,2,2,8};
        for(int i=0; i<curArray.length; i++){
            resultArray[i] -= curArray[i];
        }
        System.out.println(Arrays.stream(resultArray).mapToObj(i->String.valueOf(i)).collect(Collectors.joining(" ")));
    }
}
