package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class BOJ7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new TreeMap<>((o1,o2)->{
            return o2.compareTo(o1);
        });
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String[] s = br.readLine().split(" ");
            map.put(s[0], s[1]);
        }
        StringBuffer sb = new StringBuffer();
        for(String s : map.keySet()){
            if(map.get(s).equals("enter")){
                sb.append(s).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
