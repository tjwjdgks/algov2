package study.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1212 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] cArr = br.readLine().toCharArray();
        StringBuffer sb = new StringBuffer();
        boolean flag = false;
        for(int i=0;i<cArr.length;i++){
            int tempnum = 4;
            int n = cArr[i]-'0';
            for(int j=0;j<3;j++){
                if(n>=tempnum){
                    sb.append(1);
                    n -= tempnum;
                    flag = true;
                }
                else{
                    if(flag)
                        sb.append(0);
                }
                tempnum /=2;
            }
        }
        if(flag == false)
            sb.append(0);
        System.out.println(sb.toString());
    }
}