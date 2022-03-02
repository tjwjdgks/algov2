package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1916 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<int[]>[] list = new List[N+1];
        for(int i=0;i<N;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list[start].add(new int[]{end,val});
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int begin = Integer.parseInt(st.nextToken());
        int finish = Integer.parseInt(st.nextToken());

        boolean [] check = new boolean[N+1];
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            return o1[1]-o2[1];
        });
        queue.add(new int[]{begin,0});

        while(!queue.isEmpty()){
            int[] curInfo = queue.poll();
            if(curInfo[0] == finish){
                System.out.println(curInfo[1]);
                return;
            }

            if(check[curInfo[0]]) continue;
            check[curInfo[0]] = true;

            for(int[] i : list[curInfo[0]]){
                if(check[i[0]]) continue;
                queue.add(new int[]{i[0],curInfo[1]+i[1]});
            }

        }

    }
}
