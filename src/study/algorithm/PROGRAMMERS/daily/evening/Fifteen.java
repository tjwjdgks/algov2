package study.algorithm.PROGRAMMERS.daily.evening;

public class Fifteen {
    public String[] solution(String my_str, int n) {
        int num = my_str.length()%n == 0 ? my_str.length()/n : my_str.length()/n + 1;
        if(num == 1) return new String[]{my_str};
        String [] answer = new String[num];
        for(int i= 0;i<num;i++){
            if(i == num-1){
                answer[i] = my_str.substring(i*n);
            }
            else{
                answer[i] = my_str.substring(i*n,i*n+n);
            }
        }
        return answer;
    }
}
