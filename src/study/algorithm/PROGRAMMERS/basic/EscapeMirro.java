package study.algorithm.PROGRAMMERS.basic;

import java.util.*;

class EscapeMirro {
    public int solution(String[] maps) {
        char[][] startToLaber = new char[maps.length][];
        char[][] laberToExit = new char[maps.length][];
        for(int i=0; i<maps.length; i++) {
            startToLaber[i] = maps[i].toCharArray();
            laberToExit[i] = maps[i].toCharArray();
        }
        int n = maps.length;
        int m = maps[0].length();
        int startToEnd = Integer.MAX_VALUE/2;
        int startY = 0;
        int startX = 0;
        int laberY = 0;
        int laberX = 0;
        int exitY = 0;
        int exitX = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(startToLaber[i][j] == 'S') {
                    startY = i;
                    startX = j;
                }
                if(startToLaber[i][j] == 'E') {
                    exitY = i;
                    exitX = j;
                }
                if(startToLaber[i][j] == 'L') {
                    laberY = i;
                    laberX = j;
                }
            }
        }
        int answer = Math.min(startToEnd, getDistance(n, m, startY, startX, laberY, laberX, startToLaber) + getDistance(n, m, laberY, laberX, exitY, exitX, laberToExit));
        return answer == Integer.MAX_VALUE/2 ? -1 : answer;
    }
    private int getDistance(int n, int m, int startY, int startX, int endY, int endX, char[][] area) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX, 0});
        while(!queue.isEmpty()){
            int [] index = queue.poll();
            if(index[0]<0 || index[1]<0 || index[0]>=n || index[1]>=m) continue;
            if(area[index[0]][index[1]] == 'X') continue;
            if(index[0] == endY && index[1] == endX) return index[2];
            area[index[0]][index[1]] = 'X';
            queue.add(new int[]{index[0]+1, index[1], index[2]+1});
            queue.add(new int[]{index[0]-1, index[1], index[2]+1});
            queue.add(new int[]{index[0], index[1]+1, index[2]+1});
            queue.add(new int[]{index[0], index[1]-1, index[2]+1});

        }
        return Integer.MAX_VALUE/2;
    }
}
