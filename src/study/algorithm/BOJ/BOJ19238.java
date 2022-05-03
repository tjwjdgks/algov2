package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ19238 {
    public int N,M,L;
    public int [][] table;
    public int taxiPosY, taxiPosX;
    public final int MUL = 1000;

    public int [] dy = {1,-1,0,0};
    public int [] dx = {0,0,1,-1};
    public List<Integer>[][] destList;
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        table= new int[N][N];
        for(int i=0;i<N;i++){
            table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(num->Integer.parseInt(num)).toArray();
        }
        st = new StringTokenizer(br.readLine());
        taxiPosY = Integer.parseInt(st.nextToken())-1;
        taxiPosX = Integer.parseInt(st.nextToken())-1;
        // 2부터 승객의 index를 나타냄
        destList = new List[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                destList[i][j] = new ArrayList<>();
            }
        }
        for(int i=0;i<M;i++){
            int[] crew = Arrays.stream(br.readLine().split(" ")).mapToInt(num -> Integer.parseInt(num)-1).toArray();
            table[crew[0]][crew[1]] = i+2;
            destList[crew[2]][crew[3]].add((i+2)*MUL);
        }
        int count = 0;
        while(count<M){
            // index // y // x  // 소모한 연료 수
            int[] nextPass  = getPassenger();
            taxiPosY = nextPass[1];
            taxiPosX = nextPass[2];
            table[taxiPosY][taxiPosX] = 0;
            // y // x // 소모한 연료 수
            int[] goDest = goPassenger(nextPass[0]*MUL);
            taxiPosY = goDest[0];
            taxiPosX =  goDest[1];
            if(nextPass[3] == -1 || goDest[2]== -1){
                System.out.println(-1);
                return;
            }
            int totalUse = nextPass[3] + goDest[2];
            if(L - totalUse<0){
                System.out.println(-1);
                return;
            }

            L += goDest[2] - nextPass[3];
            count++;
        }
        System.out.println(L);
    }

    private int[] goPassenger(int destNum) {
        boolean [][]checkArr = new boolean[N][N];
        checkArr[taxiPosY][taxiPosX] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{taxiPosY,taxiPosX,0});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            for(int i : destList[poll[0]][poll[1]]){
                if(i == destNum){
                    return poll;
                }
            }
            for(int i=0;i<4;i++){
                int tempy = poll[0] + dy[i];
                int tempx = poll[1] + dx[i];
                if(isIn(tempy,tempx) && !checkArr[tempy][tempx] && table[tempy][tempx] != 1){
                    checkArr[tempy][tempx] = true;
                    queue.add(new int[]{tempy,tempx,poll[2]+1});
                }
            }
        }
        return new int[]{0,0,-1};
    }

    private boolean isIn(int y, int x) {
        return y>=0 && x>=0 && y<N && x<N;
    }

    private int[] getPassenger() {
        if(table[taxiPosY][taxiPosX]>1 && table[taxiPosY][taxiPosX]<1000){
            return new int[]{table[taxiPosY][taxiPosX],taxiPosY,taxiPosX,0};
        }
        boolean [][]checkArr = new boolean[N][N];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1[3]== o2[3]){
                if(o1[1] == o2[1]) return o1[2] - o2[2];
                return o1[1] - o2[1];
            }
            return o1[3]-o2[3];
        });
        checkArr[taxiPosY][taxiPosX] = true;
        queue.add(new int[]{0,taxiPosY,taxiPosX,0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0]>1 && cur[0]<1000) return cur;
            for(int i=0;i<4;i++){
                int tempy = cur[1] + dy[i];
                int tempx = cur[2] + dx[i];
                if(isIn(tempy,tempx) && !checkArr[tempy][tempx] && table[tempy][tempx]!=1){
                    checkArr[tempy][tempx] = true;
                    queue.add(new int[]{table[tempy][tempx],tempy,tempx,cur[3]+1});
                }
            }
        }
        return new int[]{0,0,0,-1};
    }
}
