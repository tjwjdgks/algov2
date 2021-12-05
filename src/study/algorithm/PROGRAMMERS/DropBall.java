package study.algorithm.PROGRAMMERS;

public class DropBall {
    public int solution(String[] drum) {
        int answer = 0;
        int N = drum.length;
        for (int i = 0; i < N; i++) {
            if (dropBall(N, drum, 0, i)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean dropBall(int N, String[] drum, int y, int x) {
        int currentPos_y = y;
        int currentPos_x = x;
        int count = 0;
        while (count < 2 && currentPos_y < N) {
            char currentC = drum[currentPos_y].charAt(currentPos_x);
            switch (currentC) {
                case '#':
                    currentPos_y += 1;
                    break;
                case '>':
                    currentPos_x += 1;
                    break;
                case '<':
                    currentPos_x -= 1;
                    break;
                case '*':
                    currentPos_y += 1;
                    count += 1;
                    break;
            }
        }
        if (count == 2) return false;
        return true;
    }
}
