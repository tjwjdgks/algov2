package study.algorithm.study.dk.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Han {

    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++){
            String curAnswer = Arrays.stream(br.readLine().split(" "))
                    .map(s->reverse(s))
                    .collect(Collectors.joining(" "));
            sb.append(curAnswer+"\n");
        }
        System.out.println(sb.toString());
    }
    public static String reverse(String str){
        char [] reverseArray = new char[str.length()];
        for(int i=0;i<reverseArray.length;i++){
            reverseArray[i] = str.charAt(str.length()-1-i);
        }
        return String.valueOf(reverseArray);
    }
}
