package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1976 {
    public static int[] arridx;
    public static int getParent(int idx){
        if(arridx[idx] == idx)
            return idx;
        return arridx[idx] = getParent(arridx[idx]);
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        arridx = new int[N];
        int [][] arr = new int[N][];
        for(int i=0; i<N;i++)
            arridx[i] = i;
        for(int i=0; i<N;i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(k->Integer.parseInt(k)).toArray();
        }
        int [] targetarr = Arrays.stream(br.readLine().split(" ")).mapToInt(k->Integer.parseInt(k)-1).toArray();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j] == 1){
                    int inum = getParent(i);
                    int jnum = getParent(j);
                    if(inum > jnum)
                        arridx[inum] = jnum;
                    else if(inum<jnum)
                        arridx[jnum] = inum;
                }
            }
        }
        boolean check = true;
        for(int i=0; i<M-1;i++){
            int first = targetarr[i];
            int second = targetarr[i+1];
            if(getParent(first)!=getParent(second)){
                check = false;
                break;
            }
        }
        if(check)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}

