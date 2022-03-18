package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1504 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<int[]>> edgearr = new ArrayList<>(V);
        for(int i=0; i<V;i++){
            edgearr.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            edgearr.get(u).add(new int[]{v,w});
            edgearr.get(v).add(new int[]{u,w});
        }
        int []minarr = new int[V];
        st = new StringTokenizer(br.readLine());
        int firstinter = Integer.parseInt(st.nextToken())-1;
        int secondinter = Integer.parseInt(st.nextToken())-1;
        long result1 = 0;
        long result2 = 0;
        result1 += getMinnumPath(0,firstinter,edgearr,minarr,Integer.MAX_VALUE);
        result1 += getMinnumPath(firstinter,secondinter,edgearr,minarr,Integer.MAX_VALUE);
        result1 += getMinnumPath(secondinter,V-1,edgearr,minarr,Integer.MAX_VALUE);

        result2 += getMinnumPath(0,secondinter,edgearr,minarr,Integer.MAX_VALUE);
        result2 += getMinnumPath(secondinter,firstinter,edgearr,minarr,Integer.MAX_VALUE);
        result2 += getMinnumPath(firstinter,V-1,edgearr,minarr,Integer.MAX_VALUE);

        long result = Math.min(result1,result2);
        if(result>=Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else
            System.out.println(result);
    }
    public static int getMinnumPath(int start, int end,ArrayList<ArrayList<int[]>> edgearr, int []minarr, int maxnum ){
        Arrays.fill(minarr,maxnum);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1])
                return o1[0]-o2[0];
            return o1[1]-o2[1];
        });
        pq.add(new int[]{start,0});
        minarr[start] =0;
        while(!pq.isEmpty()){
            int[] pre = pq.poll();
            if(minarr[pre[0]]<pre[1]) continue;
            ArrayList<int[]> curedge = edgearr.get(pre[0]);
            for(int[] i : curedge){
                if(minarr[i[0]]>i[1]+pre[1]){
                    minarr[i[0]] = i[1]+pre[1];
                    pq.add(new int[]{i[0],i[1]+pre[1]});
                }
            }
        }
        return minarr[end];
    }
}
