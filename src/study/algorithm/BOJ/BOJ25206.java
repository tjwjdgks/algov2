package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ25206 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double total = 0;
        double totalCount = 0;
        for(int i=0;i<20;i++){
            String[] s = br.readLine().split(" ");
            double count = Double.parseDouble(s[1]);
            switch (s[2]){
                case "A+":
                    total += count*4.5;
                    totalCount += count;
                    break;
                case "A0":
                    total += count*4.0;
                    totalCount += count;
                    break;
                case "B+":
                    total += count*3.5;
                    totalCount += count;
                    break;
                case "B0":
                    total += count*3.0;
                    totalCount += count;
                    break;
                case "C+":
                    total += count*2.5;
                    totalCount += count;
                    break;
                case "C0":
                    total += count*2.0;
                    totalCount += count;
                    break;
                case "D+":
                    total += count*1.5;
                    totalCount += count;
                    break;
                case "D0":
                    total += count*1.0;
                    totalCount += count;
                    break;
                case "F":
                    total += count*0.0;
                    totalCount += count;
                    break;
            }

        }

        System.out.println(total/totalCount);
    }
}
