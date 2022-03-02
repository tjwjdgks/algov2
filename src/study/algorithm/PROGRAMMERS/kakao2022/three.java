package study.algorithm.PROGRAMMERS.kakao2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class three {
    // fees[0] 기본 시간, fees[1] 기본 요금, fees[2] 단위 시간, fees[3]단위 요금
    // 기본 시간과 같거나 낮을시 -> 기본 요금
    // 기본 시간 보다 높을 시 -> 나머지 시간/ 단위 시간 * 단위 요금 (올림 처리)
    // 나가지 않음 차량은 23:59에 나간 것으로 계산
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        Map<Integer, List<int[]>> map = new TreeMap<>();
        // 0 in 1 out
        for(String s : records){
            String[] split = s.split(" ");
            int time = getTime(split[0]);
            int carNum = Integer.parseInt(split[1]);
            int flag = split[2].equals("IN")? 0 : 1;
            if(map.containsKey(carNum)){
                map.get(carNum).add(new int[]{time,flag});
            }
            else{
                List<int[]> tempList = new ArrayList<>();
                tempList.add(new int[]{time,flag});
                map.put(carNum,tempList);
            }
        }
        answer = new int[map.size()];
        int idx = 0;
        for(List<int[]> val : map.values()){
            answer[idx++]  = getTotal(val,fees);
        }
        return answer;
    }
    // int[0] = min int[1] flag
    private int getTotal(List<int[]> val, int[] fees) {
        final int maxTime = 60*23+59;
        int inTime = 0;
        int outTime = 0;
        for(int i=0;i< val.size();i+=2){
            inTime  += val.get(i)[0];
            outTime += (i+1<val.size())? val.get(i+1)[0] : maxTime;
        }
        int totalFee =calFee(inTime,outTime,fees);
        return totalFee;
    }

    private int calFee(int inTime, int outTime, int[] fees) {
        int gap = outTime -inTime;
        if(gap<=fees[0]) return fees[1];
        int basic  = fees[1];
        gap -= fees[0];
        int count = (gap%fees[2])==0 ? gap/fees[2] : gap/fees[2]+1;
        return fees[3]*count + basic;
    }

    private int getTime(String s) {
        String arr[] = s.split(":");
        int H = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        return H*60+M;
    }
}
