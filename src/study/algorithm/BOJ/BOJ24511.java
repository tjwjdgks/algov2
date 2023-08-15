package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] queueFlag = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        int [] init = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        int M = Integer.parseInt(br.readLine());
        int [] array =  Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            if(queueFlag[i] == 0){
                queue.add(init[i]);
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i : array){
            queue.addFirst(i);
            sb.append(queue.pollLast()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
