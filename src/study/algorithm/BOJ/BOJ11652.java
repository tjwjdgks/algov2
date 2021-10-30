package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11652 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Long,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<long[]> list = new ArrayList<>();
        for(long i : map.keySet()){
            list.add(new long[]{i,map.get(i)});
        }
        Collections.sort(list,(o1, o2) -> {
            if(o1[1] == o2[1]){
                return Long.compare(o1[0],o2[0]);
            }
            return Long.compare(o2[1],o1[1]);
        });
        System.out.println(list.get(0)[0]);
    }
}
