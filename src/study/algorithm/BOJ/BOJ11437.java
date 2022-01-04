package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// lca
public class BOJ11437 {
    public static List<List<Integer>> edges;
    public static int N,M;
    public static int [][] dp;
    public static int [] depth;
    public static int maxDepth;

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        edges = new ArrayList<>(N+1);
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        for(int i=0;i<=N;i++) edges.add(new ArrayList<>());
        dp = new int[N+1][20];
        depth = new int[N+1];
        maxDepth = (int)(Math.log(N)/Math.log(2));

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            edges.get(first).add(second);
            edges.get(second).add(first);
        }

        depth[0] = -1;
        getTree(1,0);

        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if(depth[first]<depth[second]){
                int temp = first;
                first = second;
                second = temp;
            }
            int curAnswer = getLCA(first, second);
            sb.append(curAnswer).append("\n");
        }

        System.out.println(sb.toString());
        br.close();
    }
    // first 높은 높이를 가진다
    private static int getLCA(int first, int second) {

        if(first != second){
            for(int i=maxDepth;i>=0;i--){
                if(depth[second] <= depth[dp[first][i]] )
                    first = dp[first][i];
            }
        }
        int answer = first;
        if(first == second) return answer;

        for(int i=maxDepth;i>=0;i--){
            if(dp[first][i] != dp[second][i]){
                first = dp[first][i];
                second = dp[second][i];
            }
            answer = dp[first][i];
        }
        return answer;
    }

    private static void getTree(int child, int parent) {
        depth[child] = depth[parent]+1;
        dp[child][0] = parent;

        for(int i=1;i<=maxDepth;i++){
            int temp = dp[child][i-1];
            dp[child][i] = dp[temp][i-1];
        }

        for(int num : edges.get(child)){
            if(num != parent) getTree(num,child);
        }

    }
}
