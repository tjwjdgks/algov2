package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ15684 {
    private static int n,m,h;
    private static boolean[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static boolean flag = false;
    private static int result = Integer.MAX_VALUE;


    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new boolean[h+1][n+1];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //자신 오른쪽 기준으로 넣기(b - b+1)
            map[a][b] = true;
        }
        if (m==0) {
            result = 0;
        } else {
            for (int i=0; i<=3; i++) {
                //추가 가로선 사용 개수
                flag = false;
                dfs(0,i);
                if (flag) {
                    result = i;
                    break;
                }
            }
        }
        if (result > 3) {
            //가로선 개수가 3보다 크거나 추가못했을 때
            result = -1;
        }
        System.out.println(result);
    }
    private static void dfs(int count, int max) {
        if (flag) {
            return;
        }
        if (max == count) {
            //i개만큼 가로선 설치했을 때
            if (move()) {
                //동일한 행으로 끝났을 때
                flag = true;
            }
            return;
        }
        for (int j=1; j<=h; j++) {
            for(int i=1; i<n; i++) {
                if (!map[j][i-1] && !map[j][i] && !map[j][i+1]) {
                    //왼쪽, 현재, 오른쪽 가로선 없을 때 가로선 설치
                    map[j][i] = true;
                    dfs(count+1, max);
                    map[j][i] = false;
                }
            }
        }

    }//dfs
    private static boolean move() {
        for (int i=1; i<=n; i++) {
            //열
            int index = i;
            int level = 1;
            while (level <= h) {
                //행
                if (map[level][index]) {
                    //오른쪽으로 이동
                    index += 1;
                } else if (map[level][index-1]) {
                    //왼쪽으로 이동
                    index -= 1;
                }
                //행 한칸 밑으로
                level++;
            }
            if (index == i) {
                //동일한 행이면 패스
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}