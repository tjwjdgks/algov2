package study.algorithm.PROGRAMMERS.winter_summer;

public class Split2Square {
    public int[] solution(int n, long left, long right) {
        int gap = (int)(right - left)+1;
        int [] answer = new int[gap];
        int y = (int)(left/n);
        int x = (int)(left%n)-1;
        int count = 0;
        while(count < gap){
            if(x<n-1){
                x++;
            }
            else{
                x=0;
                y= y+1;
            }
            answer[count] = Math.max(y,x)+1;
            count++;
        }
        return answer;
    }
}
