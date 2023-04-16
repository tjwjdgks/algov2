package study.algorithm.study.dk.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Henry {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        if(W == 1){
            System.out.println(0);
            return;
        }

        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1] ) return o1[0] - o2[0];
            return o2[1] - o1[1];
        });
        for(int i=0;i<arr.length;i++){
            queue.add(new int[]{i,arr[i]});
        }
        int answer = 0;
        boolean [] check = new boolean[W];
        int curStart = queue.poll()[0];
        int curEnd = queue.poll()[0];
        if(curStart>curEnd){
            int temp = curStart;
            curStart = curEnd;
            curEnd = temp;
        }
        answer += checkBetweenAndPlusGap(arr,check,curStart,curEnd);
        while(!queue.isEmpty()){
            int [] curIndex = queue.poll();
            if(check[curIndex[0]]) continue;
            if(curStart>curIndex[0]){
                answer += checkBetweenAndPlusGap(arr,check,curIndex[0],curStart);
                curStart = curIndex[0];
            }
            else if(curEnd<curIndex[0]){
                answer += checkBetweenAndPlusGap(arr,check,curEnd,curIndex[0]);
                curEnd = curIndex[0];
            }
        }
        System.out.println(answer);
    }

    private static int checkBetweenAndPlusGap(int[] arr, boolean[] check, int curStart, int curEnd) {
        check[curStart] = true;
        check[curEnd] = true;
        int gap = Math.min(arr[curStart],arr[curEnd]);
        int totalGap = 0;
        for(int i=curStart+1;i<curEnd;i++){
            totalGap += gap - arr[i];
        }
        return totalGap;
    }

    public static void main(String []args) throws IOException {
        getAnswer();
    }
}
