package study.algorithm.PROGRAMMERS;

import java.util.*;
public class CheckMostReceivedGift {
    public int solution(String[] friends, String[] gifts) {
        int friendCount = friends.length;
        int [][] friendIndex = new int[friendCount][friendCount];
        int [] gap = new int[friendCount];
        Map<String, Integer> map = getMap(friends);
        for(String gift : gifts){
            String [] array = gift.split(" ");
            int senderIndex = map.get(array[0]);
            int receiverIndex = map.get(array[1]);
            //
            friendIndex[senderIndex][receiverIndex]++;
            gap[senderIndex]++;
            gap[receiverIndex]--;
        }
        int answer = -1;
        for(int i=0; i<friendCount; i++){
            int num = 0;
            for(int j=0; j<friendCount; j++){
                if(i == j) continue;
                if(friendIndex[j][i] < friendIndex[i][j]){
                    num++;
                }
                else if(friendIndex[j][i] == friendIndex[i][j] && gap[i] > gap[j]) {
                    num++;
                }
            }
            answer = Math.max(num, answer);
        }

        return answer;
    }
    private Map<String, Integer> getMap(String[] friends) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<friends.length; i++){
            map.put(friends[i], i);
        }
        return map;
    }

}
