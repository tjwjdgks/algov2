package study.algorithm.leetCode;

public class P125 {
    public boolean isPalindrome(String s) {
        String onlyAlpa = s.replaceAll("[^0-9a-zA-Z]", "");
        String lowerAlpa = onlyAlpa.toLowerCase();
        int start = 0;
        int end = lowerAlpa.length() - 1;
        while (start < end) {
            if (lowerAlpa.charAt(start) != lowerAlpa.charAt(end)) return false;
            start++;
            end--;
        }
        return true;

    }
}
