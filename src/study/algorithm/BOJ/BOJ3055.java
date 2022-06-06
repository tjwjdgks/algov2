package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3055 {
    public static final int MAXNUM = 8;
    public static int [][] waterarr, hogarr;
    public static String [] arr;
    public static int [] dy  = {0,0,-1,1};
    public static int [] dx = {1,-1,0,0};
    public static int N,M;
    public static void waterdfs(String[] arr){
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length();j++){
                if(arr[i].charAt(j) == '*'){
                    queue.add(new int[]{i,j,0});
                    waterarr[i][j] = 0;
                }
            }
        }
        while(!queue.isEmpty()){
            int [] curarr = queue.poll();
            for(int i=0;i<4; i++){
                int tempy = curarr[0]+ dy[i];
                int tempx = curarr[1] + dx[i];
                if(tempy<N && tempy>=0 && tempx<M && tempx>=0){
                    if(waterarr[tempy][tempx] == -1 && arr[tempy].charAt(tempx) == '.' ){
                        waterarr[tempy][tempx] = curarr[2]+1;
                        queue.add(new int[]{tempy,tempx,curarr[2]+1});
                    }
                }
            }
        }
    }
    public static int hogdfs(String []arr){
        int answer = -1;
        int starty=-1, startx=-1, endy=-1, endx=-1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length();j++){
                if(arr[i].charAt(j) == 'S'){
                    starty = i;
                    startx = j;
                }
                if(arr[i].charAt(j) == 'D'){
                    endy = i;
                    endx = j;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{starty,startx,0});
        hogarr[starty][startx] = 0;
        while(!queue.isEmpty()){
            int[] curhog = queue.poll();
            if(curhog[0] == endy && curhog[1] == endx){
                return curhog[2];
            }
            for(int i=0;i<4;i++){
                int tempy = curhog[0] + dy[i];
                int tempx = curhog[1] + dx[i];
                if(tempy>=0 && tempx>=0 && tempy<N && tempx<M){
                    if(hogarr[tempy][tempx] == -1 && (arr[tempy].charAt(tempx) == '.' || arr[tempy].charAt(tempx) == 'D')){
                        if(waterarr[tempy][tempx]  == -1 ){
                            hogarr[tempy][tempx] =curhog[2]+1;
                            queue.add(new int[]{tempy,tempx,curhog[2]+1});
                        }
                        else{
                            if(waterarr[tempy][tempx]> hogarr[curhog[0]][curhog[1]]+1){
                                hogarr[tempy][tempx] =curhog[2]+1;
                                queue.add(new int[]{tempy,tempx,curhog[2]+1});
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        waterarr = new int[N][M];
        hogarr = new int[N][M];

        for(int i=0; i<N;i++){
            Arrays.fill(waterarr[i],-1);
            Arrays.fill(hogarr[i],-1);
        }

        arr =new String [N];
        for(int i=0;i<N;i++)
            arr[i] = br.readLine();
        waterdfs(arr);
        int answer =hogdfs(arr);
        if(answer == -1 )
            System.out.println("KAKTUS");
        else
            System.out.println(answer);
    }
}
