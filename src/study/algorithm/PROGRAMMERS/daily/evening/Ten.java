package study.algorithm.PROGRAMMERS.daily.evening;

public class Ten {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int [] dividerArr = new int[number+1];
        for(int i = 1;i<=number;i++){
            for(int j=i;j<=number;j+=i){
                dividerArr[j]++;
            }
        }
        for(int i = 1; i<=number;i++){
            if(dividerArr[i]>limit){
                answer += power;
            }
            else answer += dividerArr[i];
        }
        return answer;
    }

}
