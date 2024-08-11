package study.algorithm.PROGRAMMERS.basic;

import java.util.*;

public class PlaySelfMaster { public int solution(int[] cards) {
    int answer = 0;
    boolean [] check = new boolean[cards.length];
    List<Integer> list = new ArrayList<>();
    for(int i=0; i<cards.length; i++){
        if(check[i]) continue;
        list.add(getArea(i, cards, check));
    }
    Collections.sort(list);
    if(list.size() <=1) return 0;
    return list.get(list.size()-1) * list.get(list.size()-2);
}
    private int getArea(int index, int[] cards, boolean[] check) {
        if(check[index]) return 0;
        check[index] = true;
        return getArea(cards[index]-1, cards, check) + 1;
    }

}
