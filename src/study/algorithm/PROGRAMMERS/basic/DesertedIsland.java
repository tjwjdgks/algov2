package study.algorithm.PROGRAMMERS.basic;

import  java.util.*;
public class DesertedIsland {
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        List<char[]> map = new ArrayList<>();
        for(int i=0; i<maps.length; i++){
            map.add(maps[i].toCharArray());
        }
        int col = map.size();
        int row = map.get(0).length;
        for(int i=0; i<col; i++){
            for(int j=0; j<row; j++){
                if(map.get(i)[j] != 'X') {
                    list.add(calArea(map, i, j));
                }
            }
        }
        if(list.size() == 0) list.add(-1);
        return list.stream().mapToInt(i-> i).sorted().toArray();
    }
    private int calArea(List<char[]> map, int i, int j) {
        if(i<0 || j<0 || i >=map.size() || j>= map.get(0).length) return 0;
        if(map.get(i)[j] == 'X') return 0;
        int total = map.get(i)[j] - '0';
        map.get(i)[j] = 'X';
        total += calArea(map, i+1, j);
        total += calArea(map, i-1, j);
        total += calArea(map, i, j+1);
        total += calArea(map, i, j-1);
        return total;
    }
}
