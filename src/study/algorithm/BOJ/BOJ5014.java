package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5014 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int [] checkArr = new int[F+1];
        int answer = -1;
        Arrays.fill(checkArr,-1);
        checkArr[S] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        while(!queue.isEmpty()){
            int index = queue.poll();
            if(index == G){
                answer = checkArr[index];
                break;
            }
            int down = index - D;
            int up = index + U;
            if(down>0 && checkArr[down] == -1){
                checkArr[down] = checkArr[index]+1;
                queue.add(down);
            }
            if(up<=F && checkArr[up] == -1){
                checkArr[up] = checkArr[index]+1;
                queue.add(up);
            }
        }
        if(answer != -1)
            System.out.println(answer);
        else
            System.out.println("use the stairs");
    }
}
