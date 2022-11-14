package study.algorithm.PROGRAMMERS.daily.morning;

import java.util.Scanner;

public class Nine {
    public void solution(String my_string) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<n;i++){
            for(int j = 0; j<=i;j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
