package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// lca 알고리즘으로 개선 필요
public class BOJ3584Recursive {
    public static int[] arr = new int[10001];
    public static boolean[] check = new boolean[10001];
    public static void checkFirstParent(int first){
        if(arr[first] == first) {
            check[first] = true;
            return;
        }
        check[first] = true;
        checkFirstParent(arr[first]);
    }
    // MN 알고리즘
    public static int LCA(int second){
        if(check[second] == true) return second;
        return LCA(arr[second]);
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            init(N);
            for(int j=0; j<N-1;j++){
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                arr[child] = parent;
            }
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            check[first] = true;
            checkFirstParent(first);
            int answer = LCA(second);
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void init(int N){
        for(int i=0;i<=N;i++){
            arr[i] = i;
            check[i] = false;
        }
    }
}
