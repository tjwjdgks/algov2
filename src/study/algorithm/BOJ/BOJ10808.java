package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ10808 {
    public static void getAnswer() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String s;
        while((s =br.readLine())!= null ){
            if(s.isEmpty()) break;
            char[] carr = s.toCharArray();
            int [] countArr = new int[4];
            for(char c : carr){
                if(Character.isLowerCase(c))
                    countArr[0]++;
                else if(Character.isUpperCase(c))
                    countArr[1]++;
                else if(Character.isDigit(c))
                    countArr[2]++;
                else
                    countArr[3]++;
            }
            for(int i : countArr)
                sb.append(i).append(" ");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
