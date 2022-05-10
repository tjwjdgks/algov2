package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ16936 {
    public long [] arr;
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToLong(i->Long.parseLong(i)).toArray();
        long [][] numCountArr = new long[N][3];
        for(int i=0;i<N;i++){
            numCountArr[i] = getCount(arr[i]);
        }
        Arrays.sort(numCountArr, (o1, o2) -> {
            if(o2[0] == o1[0])
                return Long.compare(o1[1],o2[1]);
            return Long.compare(o2[0],o1[0]);
        });
        StringBuffer sb = new StringBuffer();
        for(long[] i :numCountArr){
            sb.append(i[2]).append(" ");
        }
        System.out.println(sb.toString());
    }

    private long[] getCount(long num) {
        // 3 count, 2 count
        long i = num;
        long[] count = new long[3];
        while(i!=0 && i%3==0){
            count[0]++;
            i /=3;
        }
        while(i!=0 && i%2==0){
            count[1]++;
            i /=2;
        }
        count[2] = num;
        return count;
    }
}
