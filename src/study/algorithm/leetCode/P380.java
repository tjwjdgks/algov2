package study.algorithm.leetCode;

import java.util.*;

public class P380 {

    Set<Integer> s;
    public P380() {
        s=new HashSet<>();
    }

    public boolean insert(int val) {
        if(s.contains(val)){
            return false;
        }
        else{
            s.add(val);
            return true;
        }

    }

    public boolean remove(int val) {
        if(s.contains(val)){
            s.remove(val);
            return true;
        }
        else{
            return false;
        }
    }

    public int getRandom() {
        List<Integer> list = new ArrayList<Integer>(s);
        int r=(int)(Math.random()*s.size());

        return list.get(r);
    }
}