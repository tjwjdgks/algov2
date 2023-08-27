package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6497 {
    public static int [] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) break;
            array = new int[N+1];
            for(int i=1;i<=N;i++){
                array[i] = i;
            }
            Queue<int[]> pq = new PriorityQueue<>((o1,o2)->{
                return o1[2] - o2[2];
            });
            int total = 0;
            for(int i=0;i<M;i++){
                int [] dist = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
                total += dist[2];
                pq.add(dist);
            }
            int answer = 0;
            while(!pq.isEmpty()){
                int [] tempIndex = pq.poll();
                int first = getParent(tempIndex[0]);
                int second = getParent(tempIndex[1]);
                if(first != second){
                    answer += tempIndex[2];
                    if(first > second){
                        array[first] = second;
                    }
                    else{
                        array[second] = first;
                    }
                }
            }
            sb.append(total - answer);
        }
        System.out.println(sb.toString());
    }
    public static int getParent(int i){
        if(array[i] == i) return i;
        return array[i] = getParent(array[i]);
    }
}
