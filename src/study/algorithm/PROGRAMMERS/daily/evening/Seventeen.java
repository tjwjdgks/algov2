package study.algorithm.PROGRAMMERS.daily.evening;

public class Seventeen {
    public int solution(String my_string) {
        int answer = 0;
        String [] s = my_string.split(" ");
        answer = Integer.parseInt(s[0]);
        for(int i=1;i<s.length;i+=2){
            int num = Integer.parseInt(s[i+1]);
            if(s[i].equals("+")){
                answer += num;
            }
            else{
                answer -= num;
            }
        }
        return answer;
    }
}
