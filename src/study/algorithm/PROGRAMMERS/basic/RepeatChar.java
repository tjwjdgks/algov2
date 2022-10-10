package study.algorithm.PROGRAMMERS.basic;

public class RepeatChar {
    public String solution(String my_string, int n) {

        String [] array = my_string.split("");
        String answer = "";
        for(int i=0;i<array.length;i++){
            for(int j =0;j<n;j++){
                answer += array[i];
            }
        }

        return answer;
    }
}
