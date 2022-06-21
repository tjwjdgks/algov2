package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2162 {
    public static int [][][] arr;
    // a b c 외적
    public static int getCCW(int[] a, int [] b, int[] c){
        int abx = b[0]-a[0];
        int aby = b[1]-a[1];
        int bcx = c[0]-b[0];
        int bcy = c[1]-b[1];
        int answer = abx*bcy - aby*bcx;
        if(answer>0)
            return 1;
        else if(answer<0)
            return -1;
        else return 0;
    }
    // a > b true a<= false
    public static boolean comparearr(int [] a, int [] b){
        if(a[0] == b[0])
            return a[1] > b[1];
        return a[0] > b[0];
    }
    public static boolean IsInter(int [][] a, int [][] b){
        int a0a1b0  = getCCW(a[0],a[1],b[0]);
        int a0a1b1 = getCCW(a[0],a[1],b[1]);
        int b0b1a0 = getCCW(b[0],b[1],a[0]);
        int b0b1a1 = getCCW(b[0],b[1],a[1]);

        if(a0a1b0*a0a1b1 ==0 && b0b1a0*b0b1a1 ==0){
            if(comparearr(a[0],a[1])){
                int [] temp = a[0];
                a[0] = a[1];
                a[1] = temp;
            }
            if(comparearr(b[0],b[1])){
                int [] temp = b[0];
                b[0] = b[1];
                b[1] = temp;
            }
            // b[0]<= a[1] && a[0]<= b[1]
            return (!comparearr(b[0],a[1])) && (!comparearr(a[0],b[1]));
        }
        return (a0a1b0*a0a1b1)<=0 && (b0b1a0*b0b1a1)<=0;
    }
    public static void getAnswer() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N][2][2];
        for(int i =0;i<N;i++){
            String [] sarr = bf.readLine().split(" ");
            for(int j=0;j<4;j++){
                arr[i][j/2][j%2] = Integer.parseInt(sarr[j]);
            }
        }
        boolean [] checkarr = new boolean[N];
        int groupsize =0;
        int maxsize = 0;
        for(int i=0;i<N;i++){
            if(checkarr[i] == false){
                Queue<Integer> linkedList = new LinkedList<>();
                linkedList.add(i);
                checkarr[i] = true;
                groupsize++;
                int tempsize = 1;
                while(!linkedList.isEmpty()){
                    int curidx = linkedList.poll();
                    for(int k=0;k<N;k++){
                        if(k == curidx) continue;
                        if(checkarr[k] == false && IsInter(arr[curidx],arr[k])){
                            checkarr[k] = true;
                            tempsize++;
                            linkedList.add(k);
                        }
                    }
                }
                if(tempsize > maxsize)
                    maxsize = tempsize;
            }
        }
        System.out.println(groupsize);
        System.out.println(maxsize);

    }
}
