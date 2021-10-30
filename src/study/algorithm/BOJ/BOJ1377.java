package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1377 {
    static class Point implements Comparable<Point>{
        int num;
        int idx;
        public Point(int num, int idx){
            this.num = num;
            this.idx = idx;
        }
        @Override
        public int compareTo(Point o) {
            return this.num-o.num;
        }
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point [] points = new Point[N];

        for(int i=0;i<N;i++){
            int temp = Integer.parseInt(br.readLine());
            points[i] = new Point(temp,i);
        }
        Arrays.sort(points);
        int answer = 0;
        for(int i=0;i<N;i++){
            answer = Math.max(answer, points[i].idx - i);
        }
        System.out.println(answer+1);
    }
}
