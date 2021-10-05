package study.algorithm.BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1004 {

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(br.readLine());
            int total = 0;
            for(int j=0;j<N;j++){
                int [] circle = Arrays.stream(br.readLine().split(" ")).mapToInt(k->Integer.parseInt(k)).toArray();
                // 둘다 안속하거나, 둘다 속하면 0
                // 둘중에 하나만 속하면 1
                boolean check1 = isInside(x1,y1,circle[0],circle[1],circle[2]);
                boolean check2 = isInside(x2,y2,circle[0],circle[1],circle[2]);
                if(check1 != check2) total++;
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb.toString());
    }
    // 경계 안에 true, 경계 밖 false
    private static boolean isInside(int x, int y, int cx, int cy, int r) {
        int x_dist = Math.abs(cx-x);
        int y_dist = Math.abs(cy-y);
        int dist2 = x_dist*x_dist + y_dist*y_dist;
        int r2 = r*r;
        if(dist2<=r2) return true;
        else return false;
    }
}
