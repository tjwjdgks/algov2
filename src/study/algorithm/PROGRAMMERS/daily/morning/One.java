package study.algorithm.PROGRAMMERS.daily.morning;

public class One {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;

        for(String s : dic){
            boolean check = true;
            for(String ss : spell){
                if(!s.contains(ss)){
                    check = false;
                    break;
                }
            }
            if(check) answer++;
        }
        if(answer > 0) return 1;
        else return 2;

    }

}
