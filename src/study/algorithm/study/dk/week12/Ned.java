package study.algorithm.study.dk.week12;

import java.util.HashSet;
import java.util.Set;

public class Ned {
    public int solution(String[][] relation) {
        int answer = 0;
        int c = relation[0].length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<(1<<c);i++){

            if(!isKey(relation,i)) continue;

            if(isMinKey(set,i)){
                set.add(i);
            }
        }
        return set.size();
    }
    public boolean isKey(String[][] relation, int key){
        int size = relation.length;
        Set<String> set = new HashSet<>();
        for(String[] rel : relation){
            String s = "";
            for(int i=0;i<rel.length;i++){
                if((key&(1<<i)) == (1<<i)){
                    s += rel[i];
                }
            }
            if(set.contains(s)) return false;
            set.add(s);
        }
        return true;
    }
    public boolean isMinKey(Set<Integer> set, int i){
        for(int s : set){
            if((s&i) == s) return false;
        }
        return true;
    }
}
