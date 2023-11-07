package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1032 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] strArr = new String[N];
        String answer = "";
        for(int i=0; i<N; i++){
            strArr[i] = br.readLine();
        }
        for(int i=0; i<strArr[0].length(); i++){
            boolean isSame = true;
            char compareC = strArr[0].charAt(i);
            for(int j=1; j<N; j++){
                if(strArr[j].charAt(i) != compareC){
                    isSame = false;
                    break;
                }
            }
            answer += isSame ? compareC : "?";
        }
        System.out.println(answer);
    }
}
