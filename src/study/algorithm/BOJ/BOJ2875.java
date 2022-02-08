package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2875 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int girl = Integer.parseInt(st.nextToken());
        int boy = Integer.parseInt(st.nextToken());
        int intern = Integer.parseInt(st.nextToken());

        int maxTeam = 0;
        // + girl 많은 경우, - boy가 많은 경우
        int teamGap = girl - boy*2;

        if(teamGap>0){
            maxTeam = boy;
            intern -= teamGap;
        }
        else{
            maxTeam = girl/2;
            intern -= boy- girl/2;
            intern -= girl%2 ==0? 0:1;
        }
        if(intern>0){
            teamGap = intern%3==0? intern/3 : intern/3+1;
            maxTeam -= teamGap;
            if(maxTeam<0)
                maxTeam=0;
        }
        System.out.println(maxTeam);
    }
}
