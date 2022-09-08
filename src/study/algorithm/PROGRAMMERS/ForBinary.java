package study.algorithm.PROGRAMMERS;

public class ForBinary {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int totalRemoveZero = 0;
        int step = 0;
        while(!s.equals("1")){
            int beforeNum = s.length();
            s = s.replaceAll("0","");
            int afterNum = s.length();
            totalRemoveZero += beforeNum - afterNum;
            int curNum = s.length();
            s = getBinary(curNum);
            step++;
        }
        answer[0] = step;
        answer[1] = totalRemoveZero;
        return answer;
    }
    private String getBinary(int curNum){
        StringBuffer sb = new StringBuffer();
        while(curNum !=0){
            sb.append(curNum%2);
            curNum /=2;
        }
        return sb.reverse().toString();
    }

}
