package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ10825 {
    static class Nember implements Comparable<Nember>{
        String name;
        int korean;
        int english;
        int math;
        public Nember(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Nember o) {
            if(o.korean == this.korean){
                if(this.english == o.english){
                    if(o.math == this.math){
                        return this.name.compareTo(o.name);
                    }
                    return o.math - this.math;
                }
                return this.english - o.english;
            }
            return o.korean-this.korean;
        }
    }
    public static void getAnswer() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Nember> nembers = new ArrayList<>();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            nembers.add(new Nember(name,korean,english,math));
        }
        Collections.sort(nembers);
        StringBuffer sb = new StringBuffer();
        for(Nember i : nembers){
            sb.append(i.name).append("\n");
        }
        System.out.println(sb.toString());
    }
}
