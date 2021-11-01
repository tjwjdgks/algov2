package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BOJ10815 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        long[] totalArr = Arrays.stream(br.readLine().split(" ")).mapToLong(k->Long.parseLong(k)).toArray();
        int N = Integer.parseInt(br.readLine());
        long [] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(k->Long.parseLong(k)).toArray();

        Set<Long> set = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        for(long a : totalArr)
            set.add(a);

        for(long i : arr){
            if(set.contains(i))
                sb.append(1).append(" ");
            else
                sb.append(0).append(" ");
        }

        System.out.println(sb.toString());
    }
}
