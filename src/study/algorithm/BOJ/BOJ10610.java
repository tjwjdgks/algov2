package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ10610 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int[] nums = Arrays.stream(br.readLine().split(""))
                .sorted(Collections.reverseOrder())
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();

        int total = 0;
        for(int i=0;i<nums.length-1;i++){
            total += nums[i];
        }
        if(total%3==0 && total/3!=0 && nums[nums.length-1] == 0){
            for(int n : nums)
                sb.append(n);
            System.out.println(sb.toString());
        }
        else
            System.out.println(-1);

    }
}
