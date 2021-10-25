package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16947 {
    public static int N;
    public static List<Integer> [] arr = new List[3000];
    public static boolean [] isCirCle = new boolean[3000];
    public static boolean [] check = new boolean[3000];
    public static boolean flag = false;
    public static void dfs(int start, int current, int count){
        if(start == current && count>=2){
            isCirCle[start] = true;
            flag = true;
            return;
        }
        check[current] = true;
        for(int i : arr[current]){
            if(check[i] == false){
                dfs(start,i,count+1);
            }
            else if (start == i && count >= 2) dfs(start,i,count);
            if(flag) return;
        }
    }
    public static int bfs(int idx){
        Queue<int[]> queue = new LinkedList<>();
        Arrays.fill(check,false);
        queue.add(new int[]{idx,0});
        check[idx] = true;

        while(!queue.isEmpty()){
            int[] q  = queue.poll();
            if(isCirCle[q[0]])
                return q[1];
            for(int i : arr[q[0]]){
                if(check[i]) continue;
                queue.add(new int[]{i,q[1]+1});
                check[i] = true;
            }
        }
        return -1;
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++)
            arr[i] = new ArrayList<>();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken())-1;
            int second = Integer.parseInt(st.nextToken())-1;
            arr[first].add(second);
            arr[second].add(first);
        }
        for(int i=0;i<N;i++){
            Arrays.fill(check,false);
            flag = false;
            dfs(i,i,0);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            if(isCirCle[i])
                sb.append(0).append(" ");
            else
                sb.append(bfs(i)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
