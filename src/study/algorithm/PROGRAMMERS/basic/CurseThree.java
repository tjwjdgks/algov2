package study.algorithm.PROGRAMMERS.basic;

public class CurseThree {
    public int solution(int n) {
        int count =1;
        int num = 1;
        while(count<=n){
            if(num%3==0 || String.valueOf(num).contains("3")){
                num++;
            }
            else{
                num++;
                count++;
            }
        }
        return num-1;
    }
}
