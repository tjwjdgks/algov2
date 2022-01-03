package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// lca 알고리즘으로 개선 필요

public class BOJ3584 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N+1];
            boolean [] check = new boolean[N+1];
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
            while(arr[first] != first){
                first = arr[first];
                check[first] = true;
            }
            while(arr[second] != second){
                if(check[second] == true) break;
                second = arr[second];
            }
            sb.append(second).append("\n");
        }
        System.out.println(sb.toString());
    }
}
