package study.algorithm.PROGRAMMERS.basic;

public class OverlappingLine {
    public int solution(int[][] lines) {
        int answer = 0;
        int [] array = new int[203];
        int mid = 101;
        for(int i=0;i<lines.length;i++){
            for(int j=lines[i][0];j<lines[i][1];j++){
                array[j+mid] +=1;
            }
        }
        for(int i=0;i<array.length;i++){
            if(array[i]>=2) answer++;
        }
        return answer;
    }
}
