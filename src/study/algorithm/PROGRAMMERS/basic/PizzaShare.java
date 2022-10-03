package study.algorithm.PROGRAMMERS.basic;

public class PizzaShare {
    public int solution(int n) {
        return n%7 ==0 ? n/7 : n/7+1;
    }

}
