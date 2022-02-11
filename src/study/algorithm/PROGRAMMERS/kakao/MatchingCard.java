package study.algorithm.PROGRAMMERS.kakao;

import java.util.*;

class MatchingCard {
    ArrayList<int[]> orders;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};

    public int solution(int[][] board, int r, int c) {
        int answer = Integer.MAX_VALUE;
        int n = 0;
        for (int[] row : board) {//개수세기
            for (int e : row) {
                if (e != 0) n++;
            }
        }
        n /= 2;//짝 개수
        int[] temp = new int[n];//12345...n
        for (int i = 0; i < n; i++) {
            temp[i] = i + 1;
        }
        orders = new ArrayList<>();//순열로 123 312 213 231..짝 뽑는순서
        permutation(n, n, new int[n], temp, 0, 0);

        for (int[] order : orders) {
            int total = 0;
            int[] point = new int[2];//최초커서위치 (r,c)
            point[0] = r;
            point[1] = c;
            int[][] cBoard = new int[4][4];//grid 만들기
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    cBoard[i][j] = board[i][j];
                }
            }
            for (int card : order) {//int[]인 order 즉, 순열로 나열한 순서 한가지씩. 123, 132, ...
                int cnt = 0;
                //목표 카드 찾기
                cnt += bfs(cBoard, card, point) + 1;
                //목표 카드 선택
                cBoard[point[0]][point[1]] = 0;
                //짝 찾기
                cnt += bfs(cBoard, card, point) + 1;
                //짝 찾기 성공
                cBoard[point[0]][point[1]] = 0;

                total += cnt;
            }

            answer = Math.min(total, answer);
        }

        return answer;
    }

    private int bfs(int[][] board, int target, int[] point) {
        int r = point[0];
        int c = point[1];
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[4][4];

        que.offer(new int[]{r, c, 0});
        visited[r][c] = true;

        while (!que.isEmpty()) {
            int[] p = que.poll();
            if (board[p[0]][p[1]] == target) {
                point[0] = p[0];
                point[1] = p[1];
                return p[2];
            }
            //4방 탐색
            for (int d = 0; d < 4; d++) {
                int nr = p[0] + dr[d];//direction 상하좌우 탐색
                int nc = p[1] + dc[d];//direction 상하좌우 탐색
                if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    que.offer(new int[]{nr, nc, p[2] + 1});
                }
            }

            //ctrl + 4방 탐색
            for (int d = 0; d < 4; d++) {
                int[] result = findCard(board, p[0], p[1], d);
                if ((result[0] != p[0] || result[1] != p[1]) && !visited[result[0]][result[1]]) {
                    visited[result[0]][result[1]] = true;
                    que.offer(new int[]{result[0], result[1], p[2] + 1});
                }
            }
        }
        return 0;
    }

    private int[] findCard(int[][] board, int r, int c, int d) {
        r += dr[d];
        c += dc[d];
        while (r >= 0 && r < 4 && c >= 0 && c < 4) {
            if (board[r][c] != 0) {
                return new int[]{r, c};
            }
            r += dr[d];
            c += dc[d];
        }
        return new int[]{r - dr[d], c - dc[d]};
    }

    private void permutation(int n, int r, int[] perms, int[] input, int depth, int flag) {
        if (depth == r) {
            int[] temp = new int[n];
            System.arraycopy(perms, 0, temp, 0, n);
            orders.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if ((flag & (1 << i)) == 0) {
                perms[depth] = input[i];
                permutation(n, r, perms, input, depth + 1, flag | (1 << i));
            }
        }
    }
}