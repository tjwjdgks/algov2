package study.algorithm.PROGRAMMERS.daily.morning;

public class Four {
    public String solution(String my_string) {
        String answer = "";
        for(int i=0; i<my_string.length();i++){
            char c = my_string.charAt(i);
            if(c>='a' && c<='z'){
                c = (char)(c-'a' + 'A');
            }
            else if(c>='A' && c<='Z'){
                c = (char)(c-'A' +'a');
            }
            answer += c;
        }
        return answer;
    }

}
