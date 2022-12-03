package study.algorithm.PROGRAMMERS.daily.evening;

public class Twelve {
    public int solution(String s) {
        int answer = 0;
        boolean flag = false;
        int wrongNum = 0;
        int correctNum = 0;
        char c = ' ';
        for(int i = 0; i <s.length();i++){
            if(flag == false){
                answer++;
                c = s.charAt(i);
                wrongNum = 0;
                correctNum = 1;
                flag = true;
                continue;
            }

            if(s.charAt(i) == c){
                correctNum++;
            }
            else wrongNum++;

            if(correctNum == wrongNum){
                flag = false;
            }
        }
        return answer;
    }
}
