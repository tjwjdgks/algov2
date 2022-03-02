package study.algorithm.PROGRAMMERS.kakao2022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class one {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> user = new HashMap<>();
        Map<Integer, Set<Integer>> reportMap = new HashMap<>();

        for(int i=0;i<id_list.length;i++){
            user.put(id_list[i],i);
            reportMap.put(i,new HashSet<>());
        }

        for(String s : report){
            String[] s_arr = s.split(" ");
            int from  = user.get(s_arr[0]);
            int to  = user.get(s_arr[1]);
            reportMap.get(to).add(from);
        }
        for(Integer i : reportMap.keySet()){
            if(reportMap.get(i).size()>=k){
                for(Integer t : reportMap.get(i)){
                    answer[t]++;
                }
            }
        }


        return answer;
    }
}
