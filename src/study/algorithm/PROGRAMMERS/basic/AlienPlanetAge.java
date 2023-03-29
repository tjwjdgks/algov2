package study.algorithm.PROGRAMMERS.basic;

public class AlienPlanetAge {
    public String solution(int age) {
        char [] cArr = String.valueOf(age).toCharArray();
        for(int i=0;i<cArr.length;i++){
            cArr[i] = (char)(cArr[i]-'0' +'a');
        }
        return new String(cArr);
    }
}
