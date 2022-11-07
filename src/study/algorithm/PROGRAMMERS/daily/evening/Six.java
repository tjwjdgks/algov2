package study.algorithm.PROGRAMMERS.daily.evening;

public class Six {
    public String solution(int[] food) {
        String answer = "";
        String left = "";
        String right = "";
        for(int i=1; i<food.length;i++){
            int val = food[i]/2;
            for(int j=0;j<val;j++){
                left = left + i;
                right = i + right;
            }
        }
        answer = left + "0" + right;
        return answer;
    }
}
