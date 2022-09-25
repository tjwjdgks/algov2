package study.algorithm.PROGRAMMERS;

import java.util.LinkedList;
import java.util.Queue;

public class QueueSame {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long totalNum = 0;
        long queue1Sum = 0;
        long queue2Sum = 0;
        for(int i : queue1){
            totalNum += i;
            queue1Sum += i;
        }
        for(int i : queue2){
            totalNum += i;
            queue2Sum += i;
        }
        if(totalNum%2 == 1) return -1;

        int queue1Count = getMinCount(queue1Sum, queue1, queue2, totalNum/2);
        int queue2Count = getMinCount(queue2Sum, queue2, queue1, totalNum/2);
        return Math.min(queue1Count, queue2Count);
    }

    public int getMinCount(long sum, int [] queue1, int [] queue2, long totalNum){
        Queue<Integer> queueFirst = new LinkedList<>();
        Queue<Integer> queueLast  = new LinkedList<>();
        for(int i : queue1){
            queueFirst.add(i);
        }
        for(int i : queue2){
            queueLast.add(i);
        }
        int count = 0;
        while(count < queue1.length + queue2.length){
            while(sum < totalNum){
                int curnum =  queueLast.poll();
                sum += curnum;
                queueFirst.add(curnum);
                count++;
            }
            while(sum > totalNum){
                int curnum = queueFirst.poll();
                sum -= curnum;
                queueLast.add(curnum);
                count++;
            }
            if(sum == totalNum){
                return count;
            }
        }
        return -1;
    }

}
