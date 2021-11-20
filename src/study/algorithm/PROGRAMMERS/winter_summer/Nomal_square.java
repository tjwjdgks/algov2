package study.algorithm.PROGRAMMERS.winter_summer;

public class Nomal_square {
    public int getGCD(int num, int rest){
        if(rest ==0)
            return num;
        return getGCD(rest,num%rest);
    }
    public long solution(int w, int h) {
        int gcd = -1;
        if(w>h)
            gcd = getGCD(w,h);
        else
            gcd = getGCD(h,w);
        long answer = (long)w*h - (w+h) +gcd;
        return answer;
    }
}
