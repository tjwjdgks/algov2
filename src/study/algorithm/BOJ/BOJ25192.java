package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ25192 {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int total = 0;
        for(int i=0;i<N;i++){
            String s = br.readLine();
            if(s.equals("ENTER")){
                total += set.size();
                set = new HashSet<>();
            }
            else {
                set.add(s);
            }
        }
        total += set.size();
        System.out.println(total);
    }
}
