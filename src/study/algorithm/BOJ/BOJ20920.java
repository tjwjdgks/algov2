package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Word{
    int i;
    String s;
    public Word(int i, String s){
        this.i = i;
        this.s  = s;
    }
}
public class BOJ20920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Word> map = new HashMap<>();
        for(int i=0; i<N;i++){
            String s = br.readLine();
            if(s.length()>= M){
                if(map.containsKey(s)){
                    map.get(s).i += 1;
                }
                else{
                    Word w = new Word(1, s);
                    map.put(s, new Word(1, s));
                }
            }
        }
        List<String> strings = map.values().stream().sorted((o1, o2) -> {
            if (o2.i == o1.i) {
                if (o2.s.length() == o1.s.length()) {
                    return o1.s.compareTo(o2.s);
                }
                return o2.s.length() - o1.s.length();
            }
            return o2.i - o1.i;
        }).map(i -> i.s).collect(Collectors.toList());
        StringBuffer sb = new StringBuffer();
        for(String s : strings){
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());

    }
}
