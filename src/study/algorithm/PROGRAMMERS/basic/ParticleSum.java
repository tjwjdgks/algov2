package study.algorithm.PROGRAMMERS.basic;

public class ParticleSum {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int startIndex = 0;
        int endIndex = 0;
        int gap = Integer.MAX_VALUE;
        int sum = 0;
        while(sum < k) {
            sum += sequence[endIndex++];
        }
        for(int i=endIndex; i<=sequence.length; i++){
            while(sum > k) {
                sum -= sequence[startIndex++];
            }
            if(sum == k) {
                int curGap = i - startIndex + 1;
                if(curGap < gap) {
                    gap = curGap;
                    answer[0] = startIndex;
                    answer[1] = i-1;
                }
            }
            if(i==sequence.length) continue;
            sum += sequence[i];
        }
        return answer;
    }
}
