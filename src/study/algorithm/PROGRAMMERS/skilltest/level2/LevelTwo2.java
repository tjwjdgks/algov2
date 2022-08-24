package study.algorithm.PROGRAMMERS.skilltest.level2;

import java.util.*;
class LevelTwo2 {
    public int solution(int n, int k) {
        int answer = 0;
        String numStr = getNum(n,k);
        System.out.println(numStr);
        String [] numArr =  numStr.split("0");
        for(String num : numArr){
            if(num.isEmpty()) continue;
            if(isPrime(Long.parseLong(num))){
                answer++;
            }
        }
        return answer;
    }
    public String getNum(int n, int k){
        StringBuffer sb = new StringBuffer();
        while(n!=0){
            sb.append(n%k);
            n /= k;
        }
        return sb.reverse().toString();

    }
    public boolean isPrime(long num){
        if(num == 1) return false;
        for(long i=2;i<=Math.sqrt(num);i++){
            if(num%i==0) return false;
        }
        return true;
    }
}
