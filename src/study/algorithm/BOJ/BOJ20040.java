package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20040 {
    public static int getParent(int [] arridx,int idx){
        if(arridx[idx] == idx)
            return idx;
        return arridx[idx] = getParent(arridx,arridx[idx]);
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        for(int i=0;i<arr.length;i++)
            arr[i] = i;
        int count = -1;
        boolean check = false;
        for(int i =0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if(check) continue;
            int fristnum = getParent(arr,first);
            int secondnum = getParent(arr,second);
            if(fristnum> secondnum){
                arr[fristnum] = secondnum;
            }
            else if(fristnum<secondnum){
                arr[secondnum] = fristnum;
            }
            else{
                count = i;
                check = true;
            }
        }
        if(count == -1)
            System.out.println(0);
        else
            System.out.println(count+1);
    }
}
