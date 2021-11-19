package study.algorithm.PROGRAMMERS.winter_summer;

public class Area {
    public class Solution {
        public long solution(int[][] land, int P, int Q) {
            long answer = 0;
            int left = Integer.MAX_VALUE;
            int right = 0;
            int N = land.length;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    left = Math.min(left,land[i][j]);
                    right = Math.max(right,land[i][j]);
                }
            }
            while(left<=right){
                int mid = (left+right)/2;
                long cost_c = calculate(mid,P,Q,land);
                long cost_n = calculate(mid+1,P,Q,land);
                if(cost_c<=cost_n){
                    answer = cost_c;
                    right = mid-1;
                }
                else{
                    answer = cost_n;
                    left = mid+1;
                }
            }
            return answer;
        }
        private long calculate(int mid, int P, int Q, int [][] land){
            long total = 0;
            int N = land.length;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(land[i][j]<mid)
                        total+= (long)P*Math.abs(mid-land[i][j]);
                    else if(land[i][j]>mid)
                        total+= (long)Q*Math.abs(land[i][j]-mid);
                }
            }
            return total;
        }
    }
}
