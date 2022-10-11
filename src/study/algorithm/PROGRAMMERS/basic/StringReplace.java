package study.algorithm.PROGRAMMERS.basic;

public class StringReplace {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] nono={"ayaaya","yeye","woowoo","mama"};
        String[] yes={"aya","ye","woo","ma"};
        for(String str : babbling){
            String chk=str;
            for(String nope : nono){
                chk=chk.replace(nope,"X");
            }
            for(String yeah : yes){
                chk=chk.replace(yeah,"");
            }
            if(chk.length() == 0){
                answer++;
            }
        }
        return answer;
    }

}
