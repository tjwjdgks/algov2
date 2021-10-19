package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1373 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] cArr = br.readLine().toCharArray();
        int count = cArr.length-1;
        StringBuffer sb = new StringBuffer();
        while(count >=0){
            int tempnum = 1;
            int total = 0;
            for(int i=0;i<3;i++){
                if(count<0) break;
                if(cArr[count] == '1')
                    total += tempnum;
                tempnum *=2;
                count--;
            }
            sb.append(total);
        }
        System.out.println(sb.reverse().toString());
    }
}