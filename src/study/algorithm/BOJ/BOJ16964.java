package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16964 {
    public static List<Integer> []edges;
    public static int N;
    public static boolean [] check;
    public static int [] order;
    public static boolean checks = false;
    public static int step = 1;
    public static void dfs(int []arr, int start){
        if(N==step){
            checks = true;
            return;
        }
        for(int i=0;i<edges[start].size();i++){
            int idx = edges[start].get(i);
            if(check[idx]) continue;
            if(idx == arr[step]){
                check[idx] = true;
                step++;
                dfs(arr,idx);
            }
        }
    }
    public static void getAnswer() throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        edges = new List[N+1];
        check = new boolean[N+1];
        order = new int[N+1];
        for(int i=0;i<=N;i++)
            edges[i] = new ArrayList<>();
        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            edges[first].add(second);
            edges[second].add(first);
        }
        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        int count = 0;
        for(int i : arr){
            order[i] = count++;
        }
        for(int i=1;i<=N;i++){
            Collections.sort(edges[i],(o1,o2)->{
               return order[o1]-order[o2];
            });
        }
        if(arr[0] != 1){
            System.out.println(0);
            return;
        }
        dfs(arr,arr[0]);
        if(checks)
            System.out.println(1);
        else
            System.out.println(0);

    }
}
