package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ1300 {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] array = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        List<Integer> list = new ArrayList<>();
        list.add(array[0]);
        for(int i=1;i<N;i++){
            if(list.get(list.size()-1) < array[i]){
                list.add(array[i]);
            }
            else{
                int left = 0;
                int right = list.size()-1;
                while(left<right){
                    int mid = (left+right)/2;
                    if(list.get(mid)<array[i]){
                        left = mid+1;
                    }
                    else{
                        right = mid;
                    }
                }
                list.set(left, array[i]);
            }
        }
        System.out.println(list.size());
    }
}
