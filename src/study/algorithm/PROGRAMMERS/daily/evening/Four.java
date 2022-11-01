package study.algorithm.PROGRAMMERS.daily.evening;

public class Four {
    String [] target = new String[]{"aya","ye","woo","ma"};
    String [] nonTarget = new String[]{"ayaaya","yeye","woowoo","mama"};
    public int solution(String[] babbling) {
        int answer = 0;
        for(String s : babbling){
            String temps = s;
            for(int i=0;i<nonTarget.length;i++){
                temps  = temps.replaceAll(nonTarget[i],"#");
            }
            for(int i=0;i<target.length;i++){
                temps  = temps.replaceAll(target[i],"1");
            }
            boolean flag = true;
            for(int i=0;i<temps.length();i++){
                if(temps.charAt(i) !='1'){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }

}
