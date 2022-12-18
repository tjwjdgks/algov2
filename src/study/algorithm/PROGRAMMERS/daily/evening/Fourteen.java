package study.algorithm.PROGRAMMERS.daily.evening;

public class Fourteen {
    public int solution(String A, String B) {
        int length = A.length();
        if(A.equals(B)) return 0;
        for(int i=0; i<length;i++){
            char c = A.charAt(A.length()-1);
            A = c + A.substring(0,length-1);
            if(A.equals(B)) return (i+1);
        }
        return -1;
    }
}
