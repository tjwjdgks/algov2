package study.algorithm.PROGRAMMERS;

public class AddProcession {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[i].length;j++){
                arr1[i][j] += arr2[i][j];
            }
        }
        answer = arr1;
        return answer;
    }
}
