package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ10986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Long, Long> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long [] array = Arrays.stream(br.readLine().split(" ")).mapToLong(s->Long.parseLong(s)).toArray();
        long sum = 0;
        for(int i=0;i<N;i++){
            long curIndex = (sum+array[i])%M;
            sum = curIndex;
            map.put(curIndex, map.getOrDefault(curIndex,0L)+1);
        }
        long answer = 0;
        for(long i : map.keySet()){
            if(i == 0){
                answer += map.get(i);
            }
            long value = map.get(i);
            if(value >=2){
                answer += value*(value-1)/2;
            }
        }
        System.out.println(answer);
    }
}
