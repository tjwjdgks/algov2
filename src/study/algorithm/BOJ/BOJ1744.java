package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ1744 {
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> positiveQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Queue<Integer> negativeQueue = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num>0)
                positiveQueue.add(num);
            else
                negativeQueue.add(num);
        }
        int answer =0;
        while(positiveQueue.size()>=2 && positiveQueue.peek()>1){
            int firstNum = positiveQueue.poll();
            if(positiveQueue.peek()==1){
                answer += firstNum;
                break;
            }
            int secondNum = positiveQueue.poll();
            answer += firstNum*secondNum;
        }
        while(!positiveQueue.isEmpty()){
            answer += positiveQueue.poll();
        }

        while(negativeQueue.size()>=2){
            int firstNum = negativeQueue.poll();
            int secondNUm = negativeQueue.poll();
            answer += firstNum*secondNUm;
        }
        while(!negativeQueue.isEmpty()){
            answer += negativeQueue.poll();
        }
        System.out.println(answer);
    }
}
