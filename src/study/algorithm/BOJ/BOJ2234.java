package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2234 {
    static class Node {
        int row;
        int col;
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int[] dirX = { 0, -1, 0, 1 };
    public static int[] dirY = { -1, 0, 1, 0 };
    public static int[][] map;
    public static boolean[][] visited;
    public static int N, M, maxSize = Integer.MIN_VALUE;

    public static void getAnswer() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int roomCnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    roomCnt += 1;
                }
            }
        }
        System.out.println(roomCnt);
        System.out.println(maxSize);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                breakWall(i, j);
            }
        }
        System.out.println(maxSize);
    }

    public static void breakWall(int startRow, int startCol) {

        for (int i = 0; i < 4; i++) {
            if ((map[startRow][startCol] & (1 << i)) != 0) {
                for (int j = 0; j < visited.length; j++)
                    Arrays.fill(visited[j], false);
                map[startRow][startCol] -= (1 << i);
                bfs(startRow, startCol);
                map[startRow][startCol] += (1 << i);
            }
        }
    }

    public static void bfs(int startRow, int startCol) {

        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(startRow, startCol));
        visited[startRow][startCol] = true;
        int roomSize = 0;

        while (!q.isEmpty()) {

            Node node = q.poll();
            int row = node.row;
            int col = node.col;
            int wall = map[row][col];
            roomSize += 1;

            for (int i = 0; i < 4; i++) {

                if ((wall & (1 << i)) > 0)
                    continue;

                int nr = row + dirX[i];
                int nc = col + dirY[i];

                if (isBoundary(nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc));
                }
            }
        }
        maxSize = Math.max(maxSize, roomSize);
    }

    public static boolean isBoundary(int row, int col) {
        return (row >= 0 && row < M) && (col >= 0 && col < N);
    }

}
