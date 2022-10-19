package study.algorithm.PROGRAMMERS.daily.day3;

public class One {
    public String solution(String my_string, String letter) {
        String answer = "";
        answer = my_string.replaceAll(letter,"");
        return answer;
    }

}
