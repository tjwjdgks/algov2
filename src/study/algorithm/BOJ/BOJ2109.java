package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;



public class BOJ2109 {
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if(o2[0] == o1[0])
                return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        for(int i=0;i<n;i++){
            queue.add(Arrays.stream(br.readLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray());
        }
        int [] checkArr = new int[n+1];
        while(!queue.isEmpty()){
            int [] curNum = queue.poll();
            int maxDay = Math.min(curNum[1],n);
            for(int i=maxDay;i>0; i--){
                if(checkArr[i]<curNum[0]){
                    checkArr[i] = curNum[0];
                    break;
                }
            }
        }
        int answer = 0;
        for(int i : checkArr){
            answer += i;
        }
        System.out.println(answer);
    }
}
