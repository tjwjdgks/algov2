package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ28279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            int [] array = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
            switch (array[0]){
                case 1:
                    deque.addFirst(array[1]);
                    break;
                case 2:
                    deque.addLast(array[1]);
                    break;
                case 3:
                    if(deque.isEmpty()) sb.append(-1);
                    else sb.append(deque.pollFirst());
                    sb.append("\n");
                    break;
                case 4:
                    if(deque.isEmpty()) sb.append(-1);
                    else sb.append(deque.pollLast());
                    sb.append("\n");
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    if(deque.isEmpty()) sb.append(1);
                    else sb.append(0);
                    sb.append("\n");
                    break;
                case 7:
                    if(deque.isEmpty()) sb.append(-1);
                    else sb.append(deque.peekFirst());
                    sb.append("\n");
                    break;
                case 8:
                    if(deque.isEmpty()) sb.append(-1);
                    else sb.append(deque.peekLast());
                    sb.append("\n");
                    break;

            }
        }
        System.out.println(sb.toString());
    }
}
