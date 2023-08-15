package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ12789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] array  = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        int start = 1;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            while(!deque.isEmpty() && deque.peekLast() == start){
                deque.pollLast();
                start++;
            }
            if(start == array[i]){
                start++;
                continue;
            }
            if(array[i] > start){
                deque.add(array[i]);
            }

        }
        while(!deque.isEmpty() && deque.peekLast() == start){
            deque.pollLast();
            start++;
        }
        if(start == N+1){
            System.out.println("Nice");
        }
        else{
            System.out.println("Sad");
        }
    }
}
