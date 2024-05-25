package study.algorithm.PROGRAMMERS;

import java.util.*;
public class SerialParticalSum {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int arraySize = elements.length;
        for(int i=1; i<=arraySize; i++){
            updateSerialParticalArray(set, elements, i);
        }
        return set.size();
    }

    private void updateSerialParticalArray(Set<Integer> set, int[] totalArray, int particalSize){
        int sum = 0;
        for(int i=0; i<particalSize; i++){
            sum += totalArray[i];
        }
        set.add(sum);
        int startIndex =0;
        int endIndex = particalSize-1;
        for(int i=1; i<totalArray.length; i++){
            startIndex = (startIndex+1) % totalArray.length;
            endIndex = (endIndex+1) % totalArray.length;
            sum -= totalArray[startIndex];
            sum += totalArray[endIndex];
            set.add(sum);
        }
    }
}
