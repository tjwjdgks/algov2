package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ2444 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int len = 2*(n-1)+1;
        List<String> c = new ArrayList<>();
        for(int i=0;i<len;i++){
            c.add("*");
        }
        StringBuffer sb = new StringBuffer();
        sb.append(c.stream().collect(Collectors.joining("")));
        int start = 0;
        for(int i=0;i<4;i++){
            c.set(start," ");
            c.remove(c.size()-1);
            String s = c.stream().collect(Collectors.joining(""));
            sb.insert(0,"\n");
            sb.insert(0, s);
            sb.append("\n");
            sb.append(s);
            start++;
        }
        System.out.println(sb.toString());
    }
}
