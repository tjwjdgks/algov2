package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ11656 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        List<String> arr = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            arr.add(s.substring(i));
        }
        Collections.sort(arr);
        StringBuffer sb = new StringBuffer();
        for(String curs : arr)
            sb.append(curs).append("\n");
        System.out.println(sb.toString());
    }
}
