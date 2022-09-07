package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25304 {

    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int totalPrice = 0;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int total = Integer.parseInt(st.nextToken());
            totalPrice += price*total;
        }
        if(target == totalPrice){
            System.out.println("Yes");
        }
        else System.out.println("No");
    }
}
