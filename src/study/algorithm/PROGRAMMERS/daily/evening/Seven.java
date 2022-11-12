package study.algorithm.PROGRAMMERS.daily.evening;

public class Seven {
    public int[] solution(int num, int total) {
        int minNum = (total - (0+num-1)*num/2)/num;
        int [] answer = new int[num];
        for(int i = 0; i<num;i++){
            answer[i] = minNum + i;
        }
        return answer;
    }

}
