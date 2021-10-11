package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9093  {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer print = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            StringBuffer sb = new StringBuffer();
            String[] arr = br.readLine().split(" ");
            for(String s : arr){
                print.append(sb.append(s).reverse()).append(" ");
                sb.setLength(0);

            }
            print.append("\n");

        }
        System.out.println(print.toString());
    }
}