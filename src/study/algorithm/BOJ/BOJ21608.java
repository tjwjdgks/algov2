package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ21608 {
    int N;
    int[][] studentOrder;
    int[][] table;
    int [] dy = {0,1,0,-1};
    int [] dx = {1,0,-1,0};
    final int MUL = 100;
    Map<Integer,Integer> map = new HashMap<>();
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        studentOrder = new int[N*N][];
        table= new int[N][N];
        for(int i=0;i<N*N;i++){
            studentOrder[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(num->Integer.parseInt(num)).toArray();
        }
        for(int i=0;i<N*N;i++){
            pickSeat(i,studentOrder[i]);
        }
        int answer = getTotalStudentConditon(table);
        System.out.println(answer);
    }

    private int getTotalStudentConditon(int[][] table) {
        int[] eval = {0,1,10,100,1000};
        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int[] seatInfo = getSeatInfo(i, j, studentOrder[map.get(i * MUL + j)]);
                answer += eval[seatInfo[0]];
            }
        }
        return answer;
    }

    private void pickSeat(int index,int[] ints) {
        // 0 좋아하는 학생 인접, 1 비어인는 칸, 2 y 3 x, 4 num
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if(o2[0] == o1[0]){
                if(o2[1] == o1[1]){
                    if(o1[2] == o2[2]) return o1[3] - o2[3];
                    return o1[2] - o2[2];
                }
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(table[i][j] == 0){
                    queue.add(getSeatInfo(i,j,ints));
                }
            }
        }
        int[] data = queue.poll();
        table[data[2]][data[3]] = data[4];
        map.put(data[2]*MUL+data[3],index);
    }

    private int[] getSeatInfo(int y, int x, int[] indexData) {
        int emptyCount = 0;
        int likeCount = 0;
        for(int k = 0; k<4; k++){
            int tempy = y + dy[k];
            int tempx = x + dx[k];
            if(isIn(tempy,tempx)){
                if(table[tempy][tempx] == 0) emptyCount++;
                else{
                    for(int i=1;i<indexData.length;i++){
                        if(table[tempy][tempx] == indexData[i]){
                            likeCount++;
                        }
                    }
                }
            }
        }
        int[] info = {likeCount,emptyCount,y,x,indexData[0]};
        return info;
    }
    private boolean isIn(int tempy, int tempx) {
        return tempy>=0 && tempx>=0 && tempy<N && tempx<N;
    }
}
