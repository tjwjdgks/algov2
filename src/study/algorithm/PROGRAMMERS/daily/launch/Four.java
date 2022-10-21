package study.algorithm.PROGRAMMERS.daily.launch;

public class Four {

    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a){
            int val = n/a;
            int rest = n%a;
            answer += b*val;
            n = rest + b*val;
        }
        return answer;
    }

}
