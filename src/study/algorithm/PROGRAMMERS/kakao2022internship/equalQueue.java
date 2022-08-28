package study.algorithm.PROGRAMMERS.kakao2022internship;

import java.util.LinkedList;
import java.util.Queue;

// 두 큐 합 같게 만들기
public class equalQueue {
    int totalAnswer = Integer.MAX_VALUE;
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;

        long total = getTotal(queue1,queue2);

        long queue1Total = 0;
        for(int i : queue1) queue1Total += i;
        long queue2Total = 0;
        for(int i :queue2) queue2Total += i;

        if(total%2 == 1) return -1;

        long targetNum = total/2;

        Queue<Integer> queue1Start = new LinkedList<>();
        Queue<Integer> queue2Start = new LinkedList<>();

        for(int i : queue1) queue1Start.add(i);
        for(int i : queue2) queue2Start.add(i);


        int count1 = getCount(targetNum,queue1Total, queue1.length, queue1Start, queue2Start);
        int count2 = getCount(targetNum,queue2Total, queue2.length, queue2Start, queue1Start);

        if(count1 != -1){
            answer  = (answer == -1) ? count1 : Math.min(answer,count1);
        }
        if(count2 != -1){
            answer  = (answer == -1) ? count2 : Math.min(answer,count2);
        }
        return answer;
    }

    public int getCount(long targetNum, long total, int queueSize, Queue<Integer> queue1,
        Queue<Integer> queue2){
        int count = 0;
        int tempAnswer = 0;
        boolean flag = false;

        Queue<Integer> start = new LinkedList<>();
        start.addAll(queue1);
        Queue<Integer> end  = new LinkedList<>();
        end.addAll(queue2);

        while(count < queueSize){
            while(total > targetNum){
                int curNum =  start.poll();
                total -= curNum;
                end.add(curNum);
                count++;
                tempAnswer++;
            }
            while(total < targetNum){
                int curNum = end.poll();
                total += curNum;
                start.add(curNum);
                tempAnswer++;
            }
            if(total == targetNum){
                flag = true;
                break;
            }
        }
        return (flag == true) ? tempAnswer : -1;
    }

    public long getTotal(int[] queue1, int [] queue2){
        long total = 0;
        for(int i : queue1){
            total += i;
        }
        for(int i : queue2){
            total += i;
        }
        return total;
    }
}
