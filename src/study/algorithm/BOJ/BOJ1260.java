package study.algorithm.BOJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ1260 {
    public static boolean[][] edgearr;
    public static StringBuffer sb1 = new StringBuffer();
    public static StringBuffer sb2 = new StringBuffer();
    public static void bfs(int start, boolean[] checkarr){
        LinkedList<Integer> queue = new LinkedList<>();
        sb1.append(start+1+" ");
        queue.add(start);
        while(!queue.isEmpty()){
            int curstart = queue.pop();
            checkarr[curstart] = true;
            for(int i=0; i<edgearr[curstart].length;i++){
                if(i == curstart) continue;
                if(edgearr[curstart][i] && checkarr[i] == false){
                    checkarr[i] = true;
                    queue.add(i);
                    sb1.append(i+1+" ");
                }
            }
        }
    }
    public static void dfs(int start, boolean[] checkarr){
        sb2.append(start+1+" ");
        checkarr[start] = true;
        for(int i=0;i<edgearr[start].length;i++){
            if(i== start ) continue;
            if(edgearr[start][i] && checkarr[i]==false){
                checkarr[i] = true;
                dfs(i,checkarr);
            }
        }
    }
    public static void getAnswer(){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int start = scanner.nextInt();
        edgearr = new boolean [N][N];
        for(int i=0; i<M;i++){
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            edgearr[first-1][second-1] = true;
            edgearr[second-1][first-1] = true;
        }
        boolean [] checkarr = new boolean[N];
        bfs(start-1,checkarr);
        Arrays.fill(checkarr,false);
        dfs(start-1, checkarr);
        System.out.println(sb2.toString());
        System.out.println(sb1.toString());
    }
}
