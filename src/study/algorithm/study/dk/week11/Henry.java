package study.algorithm.study.dk.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Henry {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int [] array = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        List<Integer> list = new ArrayList<>();
        if(array[0]>array[1]) list.add(0);
        for(int i=1;i<array.length-1;i++){
            if(array[i]>array[i+1] && array[i]>array[i-1]) list.add(i);
        }
        if(array[array.length-2]<array[array.length-1]) list.add(array.length-1);
        int answer =0;
        for(int i=0;i<list.size()-1;i++){
            int start = list.get(i);
            int end = list.get(i+1);
            int minNum = Math.min(array[start],array[end]);
            for(int j=start+1;j<end;j++){
                answer += minNum - array[j];
            }
        }
        System.out.println(answer);
    }
    public static void main(String []args) throws IOException {
        getAnswer();
    }
}
