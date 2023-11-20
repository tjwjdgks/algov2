package study.algorithm.leetCode;

public class P383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] charArray = new int[26];
        for(char c : magazine.toCharArray()){
            charArray[c-'a'] +=1;
        }
        for(char c : ransomNote.toCharArray()){
            charArray[c-'a'] -=1;
            if(charArray[c-'a'] < 0) return false;
        }
        return true;
    }
}
