package study.algorithm.leetCode;

public class P58 {
    public int lengthOfLastWord(String s) {
        String[] splitArray = s.split(" ");
        int answer = 0;
        for(int i=splitArray.length-1; i>=0; i--){
            if(splitArray[i].length() != 0){
                answer = splitArray[i].length();
                break;
            }
        }
        return answer;
    }
}
