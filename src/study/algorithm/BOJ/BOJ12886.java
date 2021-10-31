package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ12886 {
    public static Set<String> set = new HashSet<>();
    public static void addQueue(Queue<int[]> queue, int A, int B, int C){
        int [] arr = {A,B,C};
        Arrays.sort(arr);
        String s = arr[0]+" "+arr[1]+" "+arr[2];
        if(!set.contains(s)){
            set.add(s);
            queue.add(new int[]{arr[0],arr[1],arr[2]});
        }
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{A,B,C});
        int answer = 0;
        while(!queue.isEmpty()){
            int[] curnum = queue.poll();
            if(curnum[0] == curnum[1] && curnum[1] == curnum[2]){
                answer = 1;
                break;
            }
            Arrays.sort(curnum);
            if(curnum[0]<curnum[1]){
                addQueue(queue,curnum[0]*2,curnum[1]-curnum[0],curnum[2]);
            }
            if(curnum[0]<curnum[2]){
                addQueue(queue,curnum[0]*2,curnum[1],curnum[2]-curnum[0]);
            }
            if(curnum[1]<curnum[2]){
                addQueue(queue,curnum[0],curnum[1]*2,curnum[2]-curnum[1]);
            }
        }
        System.out.println(answer);
    }
}
