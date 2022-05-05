package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class BOJ18870 {
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int [] arr= Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i : arr)
            set.add(i);
        HashMap<Integer,Integer> m = new HashMap<>();
        int count =0;
        for(int i : set){
            m.put(i,count++);
        }
        StringBuilder sb = new StringBuilder();
        for(int i : arr)
            sb.append(m.get(i)+" ");
        System.out.println(sb.toString());
    }
}
