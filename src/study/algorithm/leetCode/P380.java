package study.algorithm.leetCode;

import java.util.*;

public class P380 {

    Set<Integer> set;
    boolean isEdit = false;
    int [] array;

    public P380() {
        set = new HashSet();
    }

    public boolean insert(int val) {
        if(set.contains(val)) return false;
        set.add(val);
        isEdit = true;
        return true;
    }

    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            isEdit = true;
            return true;
        }
        return false;
    }

    public int getRandom() {
        if(isEdit){
            array = set.stream().mapToInt(i->i).toArray();
            isEdit = false;
        }
        int r= (int)(Math.random()*array.length);
        return array[r];
    }
}