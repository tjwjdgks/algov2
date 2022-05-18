package study.algorithm;

import study.algorithm.BOJ.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    public static void main(String[] rgs) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> lines = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            lines.add(reader.readLine());
        }
        System.out.println(lines);
    }
}

