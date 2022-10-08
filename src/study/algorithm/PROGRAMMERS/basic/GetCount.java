package study.algorithm.PROGRAMMERS.basic;

public class GetCount {
    public int[] solution(int[] num_list) {
        int oddCount = 0;
        int evenCount = 0;
        for(int i : num_list){
            if(i%2==0) evenCount++;
            else oddCount++;
        }
        int [] answer = new int[]{evenCount,oddCount};
        return answer;
    }

}
