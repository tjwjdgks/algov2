package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == -1) break;
            List<Integer> s = new ArrayList<>();
            boolean flag = false;
            for(int i=1;i<N;i++){
                if(N% i == 0){
                    s.add(i);
                }
            }
            int total = 0;
            for(int i: s){
                total += i;
            }
            if(total == N) flag = true;
            if(!flag){
                System.out.println(N + " is NOT perfect.");
            }
            else{
                System.out.println(N + " = "+ s.stream().map(i->String.valueOf(i)).collect(Collectors.joining(" + ")));
            }
        }
        System.out.println(sb.toString());
    }
}
