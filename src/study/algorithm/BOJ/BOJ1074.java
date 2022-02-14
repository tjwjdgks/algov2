package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// bruteforce
public class BOJ1074 {
    public static int r,c;
    public static int count = 0;
    public static boolean flag=  false;
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N =  Integer.parseInt(st.nextToken());
        r =  Integer.parseInt(st.nextToken());
        c =  Integer.parseInt(st.nextToken());


        int answer = dfs2(N,0,0, 1<<N,1<<N);
        System.out.println(answer-1);
    }

    // bruteforce
    private static void dfs(int n, int y1, int x1, int y2, int x2) {
        if(flag) return;
        if(n == 0){
            if( y1 == r  && x1 == c){
                flag = true;
            }
            count++;
            return;
        }
        dfs(n-1,y1,x1,(y1+y2)/2,(x1+x2)/2);
        dfs(n-1,y1,(x1+x2)/2,(y1+y2)/2,x2);
        dfs(n-1,(y1+y2)/2,x1,y2,(x1+x2)/2);
        dfs(n-1,(y1+y2)/2,(x1+x2)/2,y2,x2);
    }
    private static int dfs2(int n, int y1, int x1, int y2, int x2) {
        if(n == 0){
            return 1;
        }
        int answer = 0;
        if(r>=y1 && c>=x1 && r<(y1+y2)/2 && c<(x1+x2)/2){
            answer += dfs2(n-1,y1,x1,(y1+y2)/2,(x1+x2)/2);
            return answer;
        }
        answer += Math.pow((1 << (n - 1)),2);
        if(r>=y1 && c>=(x1+x2)/2 && r<(y1+y2)/2 && c<x2){
            answer += dfs2(n-1,y1,(x1+x2)/2,(y1+y2)/2,x2);
            return answer;
        }
        answer += Math.pow((1 << (n - 1)),2);
        if(r>=(y1+y2)/2 && c>=x1 && r<y2 && c<(x1+x2)/2){
            answer += dfs2(n-1,(y1+y2)/2,x1,y2,(x1+x2)/2);
            return answer;
        }
        answer += Math.pow((1 << (n - 1)),2);
        if(r>=(y1+y2)/2 && c>=(x1+x2)/2 && r<y2 && c<x2){
            answer += dfs2(n-1,(y1+y2)/2,(x1+x2)/2,y2,x2);
            return answer;
        }
        return answer;
    }
}
