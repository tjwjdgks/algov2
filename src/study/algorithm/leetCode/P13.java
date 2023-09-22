package study.algorithm.leetCode;

import java.util.*;
public class P13 {
    public int romanToInt(String s) {
        String [] roman = {"CM", "CD", "XC", "XL", "IX", "IV","I", "V", "X", "L", "C", "D", "M"};
        int [] intNum = {900, 400, 90, 40, 9, 4, 1, 5, 10, 50, 100, 500, 1000};

        int answer = 0;
        for(int i=0; i<roman.length; i++){
            String str = roman[i];
            int val = intNum[i];
            int index =-1;
            while((index = s.indexOf(str,index+1)) != -1){
                answer += val;
            }
            s = s.replaceAll(str,"");
        }
        return answer;
    }
}
