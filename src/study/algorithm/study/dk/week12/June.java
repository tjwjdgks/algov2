package study.algorithm.study.dk.week12;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class June {
    class Assignment{
        int time;
        int timeSpend;
        String subject;
        public Assignment(String subject, int time, int timeSpend){
            this.subject = subject;
            this.time = time;
            this.timeSpend = timeSpend;
        }
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Arrays.sort(plans,(o1,o2)->{
            return o1[1].compareTo(o2[1]);
        });
        int index =0;
        Deque<Assignment> pq = new ArrayDeque<>();
        for(int i=0;i<plans.length;i++){
            if(pq.isEmpty()){
                pq.add(new Assignment(plans[i][0],getTime(plans[i][1]),Integer.parseInt(plans[i][2])));
            }
            else{
                int gap =  getTime(plans[i][1])- pq.peekLast().time;
                while(!pq.isEmpty()){
                    if(pq.peekLast().timeSpend <= gap){
                        gap -= pq.peekLast().timeSpend;
                        answer[index++] = pq.peekLast().subject;
                        pq.pollLast();
                    }
                    else{
                        pq.peekLast().timeSpend -=gap;
                        break;
                    }
                }
                pq.addLast(new Assignment(plans[i][0],getTime(plans[i][1]),Integer.parseInt(plans[i][2])));
            }
        }
        while(!pq.isEmpty()){
            answer[index++] = pq.peekLast().subject;
            pq.pollLast();
        }
        return answer;
    }
    public int getTime(String time){
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0])*60 + Integer.parseInt(timeArr[1]);
    }
}
