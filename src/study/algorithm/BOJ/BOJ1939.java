package study.algorithm.BOJ;

import javax.xml.stream.events.EndDocument;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1939 {
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Map<Integer, Integer>> list = new ArrayList<>(N+1);
        for(int i=0;i<=N;i++) list.add(new HashMap<>());

        for(int i=0;i<M;i++){
            st =new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            addNum(list, first, second ,val);
            addNum(list, second, first, val);
        }

        st = new StringTokenizer(br.readLine());
        int firstF = Integer.parseInt(st.nextToken());
        int secondF = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            return o2[0] - o1[0];
        });
        queue.add(new int[]{Integer.MAX_VALUE,firstF});
        boolean [] check = new boolean[N+1];
        check[firstF] = true;

        while(!queue.isEmpty()){
            int [] curNum = queue.poll();
            check[curNum[1]] = true;
            if(curNum[1] == secondF) {
                System.out.println(curNum[0]);
                return;
            }
            Map<Integer, Integer> intMap = list.get(curNum[1]);
            for(int i : intMap.keySet()){
                if(check[i]) continue;
                int val = Math.min(curNum[0],intMap.get(i));
                queue.add(new int[]{val,i});
            }
        }
    }

    private void addNum(List<Map<Integer, Integer>> list, int first, int second, int val) {
        int curNum = val;
        if(list.get(first).containsKey(second)){
            curNum = Math.max(list.get(first).get(second),val);
        }
        list.get(first).put(second,curNum);
    }
}
