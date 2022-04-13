package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1069 {
    public static double getDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }
    public static void getAnswer() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // X Y D T
        double [] arr = Arrays.stream(bf.readLine().split(" ")).mapToDouble(i->Double.parseDouble(i)).toArray();
        double distance = getDistance(arr[0],arr[1],0,0);

        int jump = (int)(distance/arr[2]);
        double jumpafter = distance - jump*arr[2];

        double result = distance;
        result = Math.min(result,jumpafter+jump*arr[3]);
        if(jump>0){
            result = Math.min(result,(jump+1)*arr[3]);
        }
        else{
            result = Math.min(result, arr[2]-jumpafter + arr[3]);
            if(distance < arr[2]) result = Math.min(result, 2*arr[3]);
        }
        System.out.println(result);
    }
}
