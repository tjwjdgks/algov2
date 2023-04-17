package study.algorithm.study.dk.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bear {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N][];
        for(int i=0;i<N;i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        }
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<(1<<N);i++){
            List<Integer> arr1 = new ArrayList<>();
            List<Integer> arr2 = new ArrayList<>();
            for(int j=0;j<N;j++){
                if((i&(1<<j))==0){
                    arr1.add(j);
                }
                else arr2.add(j);
            }
            if(arr1.size() != arr2.size()) continue;
            int s = arr1.size();
            int tempArr1Total = 0;
            int tempArr2Total = 0;
            for(int f=0;f<s;f++){
                for(int e=0;e<s;e++){
                    if(f==e) continue;
                    tempArr1Total += arr[arr1.get(f)][arr1.get(e)];
                    tempArr2Total += arr[arr2.get(f)][arr2.get(e)];
                }
            }
            answer = Math.min(answer,Math.abs(tempArr1Total-tempArr2Total));
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        getAnswer();
    }
}
