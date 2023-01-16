package study.algorithm.PROGRAMMERS.kakao2023;

import java.util.Deque;
import java.util.LinkedList;

public class Three {
    public int[][] globalUsers;
    public int[] globalEmoticons;
    public int maxCount = 0;
    public int maxTotal = 0;
    public int maxStep = 0;
    public int[] discount = {40,30,20,10};
    public void dfs(int step, Deque<Integer> deque){
        if(step == maxStep){
            calEmotions(deque);
            return;
        }
        for(int i=0; i<discount.length;i++){
            deque.addLast(discount[i]);
            dfs(step+1,deque);
            deque.pollLast();
        }
        return;
    }
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        globalUsers = users;
        globalEmoticons = emoticons;
        maxStep = emoticons.length;
        Deque<Integer> deque = new LinkedList<>();
        dfs(0,deque);
        answer[0] = maxCount;
        answer[1] = maxTotal;
        return answer;
    }
    // globalEmoticons;
    public void calEmotions(Deque<Integer> deque){
        int index = 0;
        int [] curUsers = new int[globalUsers.length];
        for(int i : deque){
            for(int j=0;j<globalUsers.length;j++){
                if(globalUsers[j][0]<=i){
                    curUsers[j] += globalEmoticons[index]/100*(100-i);
                }
            }
            index++;
        }
        int curMaxCount =0;
        int curMaxTotal = 0;
        for(int i=0;i<curUsers.length;i++){
            if(curUsers[i]>=globalUsers[i][1]){
                curMaxCount +=1;
            }
            else{
                curMaxTotal += curUsers[i];
            }
        }
        if(curMaxCount>maxCount){
            maxCount = curMaxCount;
            maxTotal = curMaxTotal;
        }
        else if(curMaxCount == maxCount && curMaxTotal > maxTotal){
            maxTotal = curMaxTotal;
        }
    }
}
