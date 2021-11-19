package study.algorithm.PROGRAMMERS.winter_summer;

public class VisitLength {
    public int [] dy = {1,0,-1,0};
    public int [] dx = {0,1,0,-1};
    public String directionTag = "URDL";
    public int solution(String dirs) {
        int answer = 0;
        boolean [][][] checkArr = new boolean[11][11][4];
        int curY = 5;
        int curX = 5;
        for(char c : dirs.toCharArray()){
            int direction = directionTag.indexOf(c);
            int tempY = curY+dy[direction];
            int tempX = curX+dx[direction];

            if(tempY>=0 && tempX>=0 && tempY<11 && tempX<11){
                if(!checkArr[curY][curX][direction]){
                    answer++;
                    checkArr[curY][curX][direction] = true;
                    checkArr[tempY][tempX][(direction+2)%4] = true;
                }
                curY = tempY;
                curX = tempX;
            }
        }
        return answer;
    }
}
