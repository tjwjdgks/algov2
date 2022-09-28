package study.algorithm.PROGRAMMERS;

public class BalloonBetweenNum {
    public int solution(int[] a) {
        int answer = 0;
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];

        int left = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            left = Math.min(left,a[i]);
            leftMin[i] = left;
        }

        int right = Integer.MAX_VALUE;
        for(int i=a.length-1;i>=0;i--){
            right = Math.min(right, a[i]);
            rightMin[i] = right;
        }

        for(int i=0;i<a.length;i++){
            if(leftMin[i] == a[i] || rightMin[i] == a[i]){
                answer++;
            }
        }
        return answer;
    }

}
