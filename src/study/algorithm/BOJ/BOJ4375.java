package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4375 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuffer sb = new StringBuffer();
        while((s= br.readLine())!=null && !s.isEmpty()){
            int divideNum = Integer.parseInt(s);
            int num = 1;
            int count = 1;
            while(true){
                if(num%divideNum == 0){
                    sb.append(count).append("\n");
                    break;
                }
                num %= divideNum;
                num = num*10+1;
                count++;
            }
        }
        System.out.println(sb.toString());
    }
}
