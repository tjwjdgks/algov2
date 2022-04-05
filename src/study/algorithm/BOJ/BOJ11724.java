package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724 {
    public static boolean check = false;
    public static int N,M;
    public static boolean [] checkarr;
    public static ArrayList<ArrayList<Integer>> arr = new ArrayList<>(N);
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        checkarr = new boolean[N];
        for(int i=0;i<N;i++)
            arr.add(new ArrayList<>());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            arr.get(from).add(to);
            arr.get(to).add(from);
        }
        Queue<Integer> queue = new LinkedList<>();
        int answer =0;
        for(int i=0;i<N;i++){
            if(checkarr[i] == false){
                answer++;
                queue.add(i);
                while(!queue.isEmpty()){
                    int curidx = queue.poll();
                    ArrayList<Integer> curarr = arr.get(curidx);
                    for(int k : curarr){
                        if(checkarr[k] == false){
                            checkarr[k] = true;
                            queue.add(k);
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
