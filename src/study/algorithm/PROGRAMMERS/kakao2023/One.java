package study.algorithm.PROGRAMMERS.kakao2023;
import java.util.*;
public class One {
    public int[] solution(String today, String[] terms, String[] privacies) {

        int todayInt = convertToInt(today);
        Map<String, Integer> map = new HashMap<>();
        for(String s: terms){
            String [] sArr = s.split(" ");
            map.put(sArr[0], Integer.parseInt(sArr[1]));
        }

        List<Integer> answerList= new ArrayList<>();
        for(int i =0;i<privacies.length;i++){
            String [] sArr = privacies[i].split(" ");

            int curInt = convertToInt(sArr[0]) + map.get(sArr[1])*28-1;

            if(todayInt>curInt){
                answerList.add(i+1);
            }
        }
        int[] answer = answerList.stream().mapToInt(i->i).toArray();
        return answer;
    }
    public int convertToInt(String days){
        String[] splitArray = days.split("\\.");
        int year = Integer.parseInt(splitArray[0]);
        int month = Integer.parseInt(splitArray[1]);
        int day = Integer.parseInt(splitArray[2]);
        return year*12*28 + month*28 + day;
    }
}
