package study.algorithm.leetCode;

public class P14 {
    public String longestCommonPrefix(String[] strs) {
        int prefixSize = 0;
        int index = -1;
        boolean flag = true;
        while(flag){
            index++;
            for(int i=0;i<strs.length;i++){
                if(strs[i].length()<= index || strs[0].charAt(index) != strs[i].charAt(index)){
                    flag = false;
                    break;
                }
            }
        }
        if(index ==0) return "";
        else return strs[0].substring(0, index);
    }
}
