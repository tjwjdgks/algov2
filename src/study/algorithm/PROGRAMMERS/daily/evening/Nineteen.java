package study.algorithm.PROGRAMMERS.daily.evening;

public class Nineteen {
    public String [] numberStringArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public String [] number = {"0","1","2","3","4","5","6","7","8","9"};
    public long solution(String numbers) {
        long answer = 0;
        for(int i =0;i<numberStringArr.length;i++){
            numbers = numbers.replaceAll(numberStringArr[i], number[i]);
        }
        answer = Long.parseLong(numbers);
        return answer;
    }
}
