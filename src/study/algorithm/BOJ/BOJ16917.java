package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ16917 {
    public static void getAnswer() throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int [] arrays = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        int answer =  0;
        int chick_soy = arrays[3];
        int chick_fri = arrays[4];

        if(arrays[0] > arrays[2]*2){
            arrays[0] = arrays[2]*2;
        }
        if(arrays[1] > arrays[2]*2){
            arrays[1] = arrays[2]*2;
        }

        if(arrays[0]+ arrays[1] > arrays[2]*2){
            int min_chick = Math.min(chick_fri,chick_soy);
            answer += min_chick*2*arrays[2];
            answer += arrays[0] * (chick_soy-min_chick) + arrays[1]*(chick_fri-min_chick);

        } else{
            answer += arrays[0] *  chick_soy + arrays[1] *chick_fri;
        }
        System.out.println(answer);
    }
}
