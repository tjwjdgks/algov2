package study.algorithm.PROGRAMMERS.daily.day3;

public class Two {
    public int solution(String my_string) {
        int answer = 0;
        for(char a : my_string.toCharArray()){
            if(a>='0' && a<='9'){
                answer += a-'0';
            }
        }
        return answer;
    }

}
