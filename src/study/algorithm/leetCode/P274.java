package study.algorithm.leetCode;


import java.util.*;
public class P274  {
    public int hIndex(int[] citations) {
        for(int i=1000;i>=0; i--){
            int count = 0;
            for(int j=0;j<citations.length;j++){
                if(citations[j] >= i) count++;
            }
            if(count >=i) return i;
        }
        return 0;
    }
}
