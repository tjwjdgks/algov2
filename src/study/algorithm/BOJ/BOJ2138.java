package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2138 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String stringOriginal = br.readLine();
        String stringTarget = br.readLine();

        int count = Integer.MAX_VALUE;
        // 0 전구 킴
        count = Math.min(getNum(0,stringOriginal,stringTarget),count);
        // 1 전구 안킴
        count = Math.min(getNum(1,stringOriginal,stringTarget),count);

        if(count == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(count);
    }

    private static int getNum(int flag, String stringOriginal, String stringTarget) {
        int answer = Integer.MAX_VALUE;
        int count = 0;
        char[] curs = stringOriginal.toCharArray();
        if(flag == 0){
            curs[0] = stringOriginal.charAt(flag) == '0' ? '1' : '0';
            curs[1] = stringOriginal.charAt(flag) == '0' ? '1' : '0';
            count++;
        }

        for(int i=0;i<curs.length;i++){
            if(curs[i] != stringTarget.charAt(i)){
                if(i+1<curs.length){
                    for(int j=i;j<=i+2;j++){
                        if(j>=curs.length) break;
                        curs[j] = (curs[j] == '0') ? '1' : '0';
                    }
                    count++;
                }
                else return answer;
            }
        }
        return count;
    }

}
