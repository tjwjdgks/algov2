package study.algorithm.PROGRAMMERS.basic;

import java.util.*;

public class MakeStar {
    public String[] solution(int[][] line) {
        List<int[]> list = new ArrayList<>();
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int maxX = Integer.MIN_VALUE;
        for(int i=0; i<line.length-1; i++){
            for(int j=i+1; j<line.length; j++){
                // y, x, flag : true 0, false 1
                int[] point = getPoint(line[i], line[j]);
                if(point[2] == 0) {
                    list.add(new int[]{point[0], point[1]});
                    minY = Math.min(minY, point[0]);
                    minX = Math.min(minX, point[1]);
                    maxY = Math.max(maxY, point[0]);
                    maxX = Math.max(maxX, point[1]);
                }
            }
        }
        char[][] array = new char[maxY-minY+1][maxX-minX+1];
        for(int i=0; i<=maxY-minY; i++){
            for(int j=0; j<=maxX-minX; j++){
                array[i][j] = '.';
            }
        }
        for(int[] point : list) {
            array[point[0]-minY][point[1]-minX] = '*';
        }
        String[] answer = new String[array.length];
        for(int i=0; i<array.length; i++){
            answer[i] = new String(array[array.length-1-i]);
        }
        return answer;
    }
    // AX + By + C line1
    // Cx + Dy + F line2
    private int[] getPoint(int[] line1, int[] line2) {
        long bottom = (long)line1[0] * line2[1] - (long)line1[1] * line2[0];
        if(bottom == 0) return new int[]{0, 0, -1};
        long topX = (long)line1[1] * line2[2] - (long)line1[2] * line2[1];
        long topY = (long)line1[2] * line2[0] - (long)line1[0] * line2[2];
        if(topX % bottom == 0 && topY % bottom == 0) {
            return new int[]{(int)(topY/bottom), (int)(topX/bottom), 0};
        }
        return new int[]{0, 0, -1};
    }
}
