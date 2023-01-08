package study.algorithm.PROGRAMMERS.daily.launch;

public class Nine {
    public String solution(String my_string, int num1, int num2) {
        char []cArray = my_string.toCharArray();
        swapC(cArray, num1, num2);
        String answer = new String(cArray);
        return answer;
    }
    public void swapC(char [] cArray, int num1, int num2){
        char c = cArray[num1];
        cArray[num1] = cArray[num2];
        cArray[num2] = c;
    }
}
