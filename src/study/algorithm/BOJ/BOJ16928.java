package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16928 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ladder = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> ladderMap = new HashMap<>();
        Map<Integer, Integer> snakeMap = new HashMap<>();

        for(int i=0;i<ladder;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            ladderMap.put(first,second);
        }

        for(int i=0;i<snake;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            snakeMap.put(first,second);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,0});
        boolean [] check = new boolean[201];
        int answer = 0;
        while(!queue.isEmpty()){
            int[] curnode = queue.poll();
            if(curnode[0]>=100){
                answer = curnode[1];
                break;
            }

            for(int i=1;i<=6;i++){
                int idx = curnode[0] + i;
                if(check[idx]) continue;
                check[idx] = true;
                if(ladderMap.containsKey(idx)){
                    int tempnum = ladderMap.get(idx);
                    check[tempnum] = true;
                    queue.add(new int[]{tempnum,curnode[1]+1});
                }
                else if(snakeMap.containsKey(idx)){
                     int tempnum = snakeMap.get(idx);
                     check[tempnum] = true;
                     queue.add(new int[]{tempnum,curnode[1]+1});
                }
                else
                    queue.add(new int[]{idx,curnode[1]+1});
            }
        }
        System.out.println(answer);
    }
}
