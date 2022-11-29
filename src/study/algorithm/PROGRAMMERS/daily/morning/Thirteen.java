package study.algorithm.PROGRAMMERS.daily.morning;

public class Thirteen {
    public int[] solution(int[] numbers, String direction) {
        int [] answer = new int[numbers.length];

        int startPoint = 0;
        if(direction.equals("left")){
            startPoint = 1;
        }
        else{
            startPoint = numbers.length-1;
        }

        int count = 0;
        while(count < numbers.length){
            answer[count++] = numbers[startPoint++];

            if(startPoint == numbers.length){
                startPoint = 0;
            }
        }

        return answer;
    }

}
