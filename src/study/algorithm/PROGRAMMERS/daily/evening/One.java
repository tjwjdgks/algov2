package study.algorithm.PROGRAMMERS.daily.evening;

public class One {
    public String solution(String my_string, String letter) {
        String answer = "";
        answer = my_string.replaceAll(letter,"");
        return answer;
    }

}
