package study.algorithm.PROGRAMMERS.daily.evening;

public class Twenty {
    public int solution(String t, String p) {
        int answer = 0;
        int size = p.length();
        long standNum = Long.parseLong(p);
        for(int i=0;i<=t.length()-size;i++){

            String curS = t.substring(i, i+size);
            long curNum = Long.parseLong(curS);
            if(curNum <= standNum) answer++;
        }
        return answer;
    }
}
