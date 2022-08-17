package study.algorithm.PROGRAMMERS.skilltest;

public class LevelOne1 {
    public String solution(String s) {
        String answer = "";
        // 마지막 공백을 남기기 위해 -1 해준다. 없을 경우 문자열 가장 뒤에 있는 공백들이 모두 삭제된다
        String [] arr = s.split(" ",-1);
        for(String spl : arr){

            for(int i=0;i<spl.length();i++){
                if(i%2==0){
                    answer += Character.toUpperCase(spl.charAt(i));
                }
                else
                    answer += Character.toLowerCase(spl.charAt(i));

            }
            answer += " ";
        }
        answer = answer.substring(0,answer.length()-1);
        return answer;
    }
}
