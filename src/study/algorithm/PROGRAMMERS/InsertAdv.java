package study.algorithm.PROGRAMMERS;

import java.util.*;

public class InsertAdv {
    public String solution(String play_time, String adv_time, String[] logs) {
        int totalTime = convertIntTime(play_time);
        int advTime = convertIntTime(adv_time);
        int [] timeArray = new int [totalTime+2];
        for(String log : logs){
            String [] splitLog = log.split("-");
            int startTime = convertIntTime(splitLog[0]);
            int endTime = convertIntTime(splitLog[1]);
            timeArray[startTime]++;
            timeArray[endTime]--;
        }
        for(int i=1;i<totalTime+1;i++){
            timeArray[i] += timeArray[i-1];
        }

        int startAdvTime = 0;
        int endAdvTime = advTime-1;
        int curMaxInteger = 0;
        long curMaxTotal = 0;
        long curTotal = 0;
        for(int i=0;i<=endAdvTime; i++){
            curMaxTotal += timeArray[i];
            curTotal += timeArray[i];
        }

        while(endAdvTime<totalTime){
            curTotal -= timeArray[startAdvTime];
            startAdvTime++;
            endAdvTime++;
            curTotal += timeArray[endAdvTime];
            if(curTotal> curMaxTotal){
                curMaxInteger = startAdvTime;
                curMaxTotal = curTotal;
            }
        }
        String answer = convertStringTime(curMaxInteger);
        return answer;
    }
    public String convertStringTime(int time){
        int hour = time/3600;
        int min = (time%3600) /60;
        int second = time % 60;
        return String.format("%02d:%02d:%02d", hour, min, second);
    }
    public int convertIntTime(String time){
        String [] split = time.split(":");
        return Integer.parseInt(split[0]) * 3600 + Integer.parseInt(split[1]) * 60 + Integer.parseInt(split[2]);
    }

}
