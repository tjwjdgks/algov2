package study.algorithm.PROGRAMMERS.basic;

public class Make2DArray {
    public int[][] solution(int[] num_list, int n) {
        int length = num_list.length % n == 0 ? num_list.length/n : num_list.length/n+1;
        int[][] answer = new int[length][n];
        for(int i=0;i<num_list.length;i++){
            answer[i/n][i%n] = num_list[i];
        }
        return answer;
    }
}
