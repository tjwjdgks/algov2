package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12970 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        StringBuilder sb = new StringBuilder();
        for(int i=n; i >= 0; i--){
            int A = i;
            int B = n - i;
            if(A * B < k) continue;
            int cnt = 0;
            int temp = k;
            for(int j=B; j >= 0; j--){
                for(int a=i; a >= 0; a--){
                    if(temp > a*j){
                        temp -= a*j;
                        for(int t=0; t < a; t++){
                            sb.append("A");
                            cnt++;
                        }
                        sb.append("B");
                        cnt++;
                        break;
                    } else if(temp == a*j){
                        temp -= a*j;
                        for(int t=0; t < a; t++){
                            sb.append("A");
                            cnt++;
                        }
                        for(int t=0; t < j; t++){
                            sb.append("B");
                            cnt++;
                        }
                        break;
                    }
                }
                if(temp == 0) {
                    while(cnt++ < n){
                        sb.append("A");
                    }
                    System.out.println(sb);
                    return;
                }
            }
        }
        System.out.println(-1);
        br.close();
    }
}
