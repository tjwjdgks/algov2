package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BOJ10026 {
    public static int [] dy = {0,1,-1,0};
    public static int [] dx = {-1,0,0,1};
    public static int bfs(int N, String[] arr, Map<Character, Integer> map){
        boolean [][] check = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        int areaTotal = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!check[i][j]){
                    check[i][j] = true;
                    areaTotal++;
                    queue.add(new int[]{i,j,map.get(arr[i].charAt(j))});
                    while(!queue.isEmpty()){
                        int [] curidx = queue.poll();
                        for(int k=0;k<4;k++){
                            int tempy = curidx[0] + dy[k];
                            int tempx = curidx[1] + dx[k];
                            if(tempy>=0 && tempx>=0 && tempy<N&& tempx<N){
                                if(!check[tempy][tempx] && map.get(arr[tempy].charAt(tempx))==curidx[2]){
                                    check[tempy][tempx] = true;
                                    queue.add(new int[]{tempy,tempx,curidx[2]});
                                }
                            }
                        }
                    }
                }
            }
        }
        return areaTotal;
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for(int i=0;i<N;i++)
            arr[i] = br.readLine();

        Map<Character,Integer> G_R_B = new HashMap<>();
        G_R_B.put('G',1);
        G_R_B.put('R',2);
        G_R_B.put('B',3);
        Map<Character,Integer> GR_B = new HashMap<>();
        GR_B.put('G',1);
        GR_B.put('R',1);
        GR_B.put('B',2);

        int normal = bfs(N,arr,G_R_B);
        int adnormalGreenRed =  bfs(N,arr,GR_B);
        System.out.println(normal+" "+adnormalGreenRed);
    }
}
