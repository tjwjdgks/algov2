package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Num{
    public int num;
    public String s;
    public Num(int num){
        this.num = num;
        s ="";
    }
    public Num(int num, String s){
        this.num = num;
        this.s = s;
    }
}
public class BOJ14395{
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        final int MAX = 1_000_000_000;
        final int MIN = 1;

        if(S==T){
            System.out.println(0);
            return;
        }

        Set<Integer> set = new HashSet<>();
        Queue<Num> queue = new LinkedList<>();
        queue.add(new Num(S));

        while(!queue.isEmpty()){
            Num curnum  = queue.poll();
            int num = curnum.num;
            if(num == T){
                System.out.println(curnum.s);
                return;
            }
            if(num<=Math.sqrt((double)MAX) && !set.contains(num*num) ){
                set.add(num*num);
                queue.add(new Num(num*num,curnum.s+"*"));
            }
            if(num<=MAX/2 && !set.contains(num*2)){
                set.add(num*2);
                queue.add(new Num(num*2,curnum.s+"+"));
            }
            if(!set.contains(num/num)){
                set.add(num/num);
                queue.add(new Num(num/num,curnum.s+"/"));
            }
        }
        System.out.println(-1);
    }
}
