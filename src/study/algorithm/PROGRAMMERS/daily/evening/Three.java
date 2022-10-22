package study.algorithm.PROGRAMMERS.daily.evening;

import java.util.HashMap;
import java.util.Map;

public class Three {
    public int solution(int[] topping) {
        int answer = 0;
        int leftCount = 0;
        int rightCount = 0;
        Map<Integer,Integer> leftMap = new HashMap<>();
        Map<Integer,Integer> rightMap = new HashMap<>();
        for(int i = 0; i<topping.length;i++){
            rightMap.put(topping[i],rightMap.getOrDefault(topping[i],0)+1);
        }
        rightCount = rightMap.size();

        for(int i=0;i<topping.length;i++){
            if(leftCount == rightCount ) answer++;

            if(!leftMap.containsKey(topping[i])){
                leftCount ++;
                leftMap.put(topping[i],1);
            }
            else leftMap.put(topping[i],leftMap.get(topping[i])+1);

            rightMap.put(topping[i],rightMap.get(topping[i])-1);

            if(rightMap.get(topping[i]) == 0 ){
                rightCount--;
            }

        }
        return answer;
    }

}
