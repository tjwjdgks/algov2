package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ26069 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        for(int i=0; i<N;i++){
            String [] s = br.readLine().split(" ");
            if(set.contains(s[0])){
                set.add(s[1]);
            }
            if(set.contains(s[1])){
                set.add(s[0]);
            }
        }
        System.out.println(set.size());
    }
}
