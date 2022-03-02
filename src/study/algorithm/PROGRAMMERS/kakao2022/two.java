package study.algorithm.PROGRAMMERS.kakao2022;

public class two {
    public int solution(int n, int k) {
        int answer = 0;
        String num = getNum(n, k);
        String[] split = num.split("0");
        for(String s : split){
            if(s.isEmpty()) continue;
            if(isDicimal(Long.parseLong(s))){
                answer++;
            }
        }

        return answer;
    }
    private String getNum(int n, int k){
        StringBuffer sb= new StringBuffer();
        while(n!=0){
            sb.append(n%k);
            n /=k;
        }
        sb.reverse();
        return sb.toString();
    }
    private boolean isDicimal(long parseLong) {
        if(parseLong<2) return false;
        for(long i=2;i<=Math.sqrt(parseLong);i++){
            if(parseLong%i==0)return false;
        }
        return true;
    }
}
