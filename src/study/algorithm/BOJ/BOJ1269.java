package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ1269 {

    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        Set<Integer> set = Arrays.stream(br.readLine().split(" ")).map(i->Integer.parseInt(i)).collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(br.readLine().split(" ")).map(i->Integer.parseInt(i)).collect(Collectors.toSet());
        set.retainAll(set2);
        System.out.println(first+second - set.size()*2);
    }

}
