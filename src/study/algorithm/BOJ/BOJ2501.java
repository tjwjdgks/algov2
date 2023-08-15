package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Set<Integer> set = new TreeSet<>();
        for(int i=1;i<=N;i++){
            if(N%i == 0) set.add(i);
        }
        int answer = 0;
        for(int i : set){
            K -= 1;
            if(K == 0){
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
