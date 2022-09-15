package study.algorithm.PROGRAMMERS;

public class MakeStrangeCharacter {
    public String solution(String s) {
        char[] c_arr = s.toCharArray();
        int index = 0;
        for(int i=0;i<c_arr.length;i++){
            if(c_arr[i] == ' '){
                index = 0;
            }
            else{
                if(index%2==0){
                    c_arr[i] = Character.toUpperCase(c_arr[i]);
                }
                else c_arr[i] = Character.toLowerCase(c_arr[i]);
                index++;
            }
        }
        return String.valueOf(c_arr);
    }
}
