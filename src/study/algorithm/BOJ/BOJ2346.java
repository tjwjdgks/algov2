package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] array = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        Deque<int[]> deque = new ArrayDeque<>();
        for(int i=0; i<array.length;i++){
            deque.add(new int[]{i,array[i]});
        }
        StringBuffer sb = new StringBuffer();
        while(!deque.isEmpty()){
            int[] cur = deque.poll();
            sb.append(cur[0]+1).append(" ");
            if(!deque.isEmpty()){
                if(cur[1]>0){
                    for(int i=0;i<cur[1]-1;i++){
                        deque.add(deque.poll());
                    }
                }
                else{
                    for(int i=0;i<Math.abs(cur[1]);i++){
                        deque.addFirst(deque.pollLast());
                    }
                }


            }
        }
        System.out.println(sb.toString());
    }
}
