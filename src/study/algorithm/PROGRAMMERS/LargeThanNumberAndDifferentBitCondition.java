package study.algorithm.PROGRAMMERS;

public class LargeThanNumberAndDifferentBitCondition {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length;i++){
            answer[i] = getNumberDifferentBit(numbers[i]);
        }

        return answer;
    }

    public long getNumberDifferentBit(long number){
        long i = 1;
        for(i=1; i < number; i= i<<1){
            if((number & i) == 0){
                if(i == 1){
                    return number+1;
                }
                else{
                    return number + i - (i/2);
                }
            }
        }
        return number + i - (i/2);
    }

}
