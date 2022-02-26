package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1620 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String,Integer> stringMap = new HashMap<>();
        Map<Integer,String> intMap = new HashMap<>();
        for(int i=1;i<=N;i++){
            String s = br.readLine();
            stringMap.put(s,i);
            intMap.put(i,s);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<M;i++){
            String s = br.readLine();
            boolean digit = s.chars().allMatch(Character::isDigit);
            if(digit){
                sb.append(intMap.get(Integer.parseInt(s)));
            }
            else{
                sb.append(stringMap.get(s));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
