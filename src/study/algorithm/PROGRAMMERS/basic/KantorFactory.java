package study.algorithm.PROGRAMMERS.basic;

public class KantorFactory {
    public int [] dy = {1, 1, 0, 1, 1};
    public int [] dx = {0, 0, 0, 0, 0};
    public int solution(int n, long l, long r) {
        int answer = 0;
        l--;
        r--;
        while(l<=r){
            answer += getNum(n, l++);
        }
        return answer;
    }
    public long getNum(int n, long l){
        if(n == 0) return 1;
        long rest = l%5;
        long preNum = getNum(n-1, l/5);
        if(preNum == 0) return dx[(int)rest];
        else return dy[(int)rest];
    }
}
