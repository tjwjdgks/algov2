package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16940 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] edges = new List[N+1];
        int [] orders = new int[N+1];
        boolean [] checks = new boolean[N+1];

        for(int i=0;i<=N;i++)
            edges[i] = new ArrayList<>();

        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            edges[first].add(second);
            edges[second].add(first);
        }

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(k->Integer.parseInt(k)).toArray();
        int count = 0;
        for(int i : arr)
            orders[i] = count++;

        if(arr[0]!=1){
            System.out.println(0);
            return;
        }

        for(int i=0;i<edges.length;i++){
            Collections.sort(edges[i],(o1, o2) -> {
               return orders[o1] - orders[o2];
            });
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean flag = true;
        int checkCount =0;
        checks[1] = true;
        queue.add(1);
        while(!queue.isEmpty()){
            int n = queue.poll();
            if(n!=arr[checkCount])break;
            checkCount++;

            for(int i : edges[n]){
                if(checks[i]) continue;
                checks[i] = true;
                queue.add(i);
            }
        }

        if(flag && checkCount == N)
            System.out.println(1);
        else
            System.out.println(0);

    }
}
