package study.algorithm.PROGRAMMERS.daily.evening;

public class Thirteen {
    public int solution(int[] array) {
        int answer = 0;
        for(int i : array){
            String s = String.valueOf(i);
            for(char c : s.toCharArray()){
                if(c == '7') answer++;
            }
        }
        return answer;
    }
}
