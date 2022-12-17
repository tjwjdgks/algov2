package study.algorithm.PROGRAMMERS.daily.launch;

public class Eight {
    public int solution(String my_string) {
        int answer = 0;
        String [] splitArr = my_string.split("[^0-9]");
        for(String s : splitArr){
            if(s.isEmpty()) continue;
            answer += Integer.parseInt(s);
        }
        return answer;
    }
}
