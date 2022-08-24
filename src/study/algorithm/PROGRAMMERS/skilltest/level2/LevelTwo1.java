package study.algorithm.PROGRAMMERS.skilltest.level2;

import java.util.*;
class LevelTwo1 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long curFact = 1;
        k -= 1;
        List<Integer> list = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i+1);
        }
        for(int i=1;i<n;i++){
            curFact *=i;
        }
        int count = n-1;
        int answerCount = 0;
        while(k!=0){
            int index = (int)(k/curFact);
            answerList.add(list.get(index));
            answer[answerCount++] = list.get(index);
            list.remove(index);
            k -= index*curFact;
            curFact /= count;
            count--;
        }
        for(int i=0;i<list.size();i++){
            answer[answerCount++] = list.get(i);
        }
        return answer;
    }
}
