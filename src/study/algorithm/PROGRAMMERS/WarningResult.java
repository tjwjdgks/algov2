package study.algorithm.PROGRAMMERS;

import java.util.*;
import java.util.stream.Collectors;

public class WarningResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> banlist = new HashMap<>();
        Map<String, Integer> userList = new HashMap<>();
        for(int i=0;i<id_list.length;i++){
            userList.put(id_list[i],i);
        }
        for (String userId : id_list) {
            banlist.put(userId,new HashSet<>());
        }
        for(String curReport : report){
            String [] userAndBanUser = curReport.split(" ");
            banlist.get(userAndBanUser[1]).add(userAndBanUser[0]);
        }
        for(String banUserId : banlist.keySet()){
            Set<String> reportList = banlist.get(banUserId);
            if(reportList.size()>=k){
                for(String s : reportList){
                    answer[userList.get(s)] +=1;
                }
            }
        }
        return answer;
    }
}