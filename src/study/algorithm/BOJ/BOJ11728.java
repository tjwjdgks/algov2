package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ11728 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();

        int aIdx = 0;
        int bIdx = 0;

        int [] total = new int[N+M];
        int count = 0;
        while(aIdx<N && bIdx<M){
            if(A[aIdx]<= B[bIdx])
                total[count++] = A[aIdx++];
            else
                total[count++] = B[bIdx++];
        }
        while(aIdx<N)
            total[count++] = A[aIdx++];
        while(bIdx<M)
            total[count++] = B[bIdx++];

        StringBuffer sb = new StringBuffer();

        for(int i : total){
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString());


    }
}
