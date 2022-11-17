package study.algorithm.PROGRAMMERS.daily.launch;

public class Seven {
    public int solution(int num, int k) {
        int answer = -1;
        String num_s  = Integer.toString(num);
        for(int i = 0; i< num_s.length();i++){
            if((num_s.charAt(i) - '0') == k ){
                return i+1;
            }
        }
        return answer;
    }

}
