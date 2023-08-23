package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>((o1,o2)->{
            if(Math.abs(o1) == Math.abs(o2)) return o1-o2;
            return Math.abs(o1) - Math.abs(o2);
        });
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(queue.isEmpty()) sb.append(0).append("\n");
                else sb.append(queue.poll()).append("\n");
            }
            else queue.add(num);
        }
        System.out.println(sb.toString());
    }
}
