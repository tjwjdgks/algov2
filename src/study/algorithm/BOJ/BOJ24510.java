package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ24510 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int maxNum = 0;
        for(int i=0;i<N;i++){
            String s  = br.readLine();
            maxNum = Math.max(getCountLoop(s),maxNum);
        }
        System.out.println(maxNum);
    }

    private static int getCountLoop(String s) {
        int count = 0;
        Pattern pattern = Pattern.compile("for|while");
        Matcher matcher = pattern.matcher(s);
        while(matcher.find())
            count++;
        return count;
    }
}
