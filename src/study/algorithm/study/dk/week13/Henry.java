package study.algorithm.study.dk.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Henry {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> [] list = new List[N];
        for(int i=0; i<N;i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            list[a].add(b);
            list[b].add(a);
        }
        int minPath = Integer.MAX_VALUE;
        int firstChickenEdge = -1;
        int secondChickenEdge = -2;
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                int curPath = getTotalPath(N,list, i, j);
                if(curPath<minPath){
                    minPath = curPath;
                    firstChickenEdge = i;
                    secondChickenEdge = j;
                }
            }
        }
        System.out.println((firstChickenEdge+1)+" "+(secondChickenEdge+1)+" "+minPath);
    }

    private static int getTotalPath(int N, List<Integer>[] list, int i, int j) {
        int total = 0;
        boolean [] check = new boolean[N];
        Queue<int[]> queue = new LinkedList<>();
        check[i] = true;
        check[j] = true;
        queue.add(new int[]{i,0});
        queue.add(new int[]{j,0});
        while(!queue.isEmpty()){
            int [] curIndex = queue.poll();
            total += curIndex[1];
            for(int k : list[curIndex[0]]){
                if(check[k] == false){
                    check[k] = true;
                    queue.add(new int[]{k,curIndex[1]+1});
                }
            }
        }
        return total*2;
    }

    public static void main(String []args) throws IOException {
        getAnswer();
    }
}
