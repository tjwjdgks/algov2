package study.algorithm.PROGRAMMERS.daily.launch;

public class One {
    public String solution(String X, String Y) {

        int[] xcount = new int[10];
        int[] ycount = new int[10];
        for(char c : X.toCharArray()){
            int idx = c - '0';
            xcount[idx]++;
        }
        for(char c : Y.toCharArray()){
            int idx = c - '0';
            ycount[idx]++;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=9;i>=0;i--){
            int minCount = Math.min(xcount[i],ycount[i]);
            for(int j=0;j<minCount;j++){
                sb.append(i);
            }
        }
        String answer = sb.toString();
        if(answer.isEmpty()) return "-1";
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }

}
