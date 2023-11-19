package study.algorithm.leetCode;

public class P392 {
    public boolean isSubsequence(String s, String t) {
        int startIndex = 0;
        int endIndex = s.length();
        if(endIndex == 0) return true;
        for(int i=0; i<t.length(); i++){
            if(s.charAt(startIndex) == t.charAt(i)){
                startIndex++;
            }
            if(startIndex == endIndex) return true;
        }
        return false;
    }
}
