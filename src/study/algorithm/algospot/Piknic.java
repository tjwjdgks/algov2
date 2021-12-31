package study.algorithm.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Piknic {

    public static boolean[][] firends;
    public static int dfs(boolean[] check){
        int firstFriends = -1;
        for(int i=0;i<check.length;i++){
            if(!check[i]){
                firstFriends = i;
                break;
            }
        }
        if(firstFriends  == -1) return 1;
        int total = 0;
        for(int i= firstFriends+1; i<firends.length;i++){
            if(check[i]==false && firends[firstFriends][i]){
                check[firstFriends] = true;
                check[i] = true;
                total += dfs(check);
                check[firstFriends] = false;
                check[i]= false;
            }
        }
        return total;
    }
    public static void getAnswer() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = br.readLine().charAt(0)-'0';
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int [] edges = Arrays.stream(br.readLine().split(" ")).mapToInt(num->Integer.parseInt(num)).toArray();
            int friendsWay = findWay(n,m,edges);
            sb.append(friendsWay).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int findWay(int n, int m, int[] edges) {
        firends = new boolean[n][n];
        for(int i=0;i<edges.length; i+=2){
            firends[edges[i]][edges[i+1]] = true;
            firends[edges[i+1]][edges[i]] = true;
        }
        return dfs(new boolean[n]);
    }
}
