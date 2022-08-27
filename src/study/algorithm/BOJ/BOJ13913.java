package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ13913 {
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] parent = new int[100001];
        int [] check = new int[100001];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(N);
        check[N] = 1;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur == M) {
                break;
            }
            for(int i=0;i<3; i++){
                int next = cur;
                if(i==0) next++;
                else if(i==1) next--;
                else next*=2;
                if(next<0 || next>100000) continue;
                if(check[next] == 0){
                    queue.add(next);
                    check[next] = check[cur]+1;
                    parent[next] = cur;
                }
            }
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(M);
        int index = M;
        while(index!=N){
            index = parent[index];
            stack.push(index);
        }
        StringBuffer sb = new StringBuffer();
        sb.append(check[M]-1).append("\n");
        while(!stack.isEmpty())
            sb.append(stack.pop()).append(" ");
        System.out.println(sb.toString());
    }
}
