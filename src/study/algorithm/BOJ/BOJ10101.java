package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10101 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        if(A+B+C != 180){
            System.out.println("Error");
        }
        else if(A == B && A==C){
            System.out.println("Equilateral");
        }
        else if(A != B && A!=C && B!=C){
            System.out.println("Scalene");
        }
        else{
            System.out.println("Isosceles");
        }
    }
}
