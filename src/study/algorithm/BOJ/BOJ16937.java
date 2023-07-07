package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16937 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int [][] stickers = new int[N][];
        for(int i=0;i<N;i++){
            stickers[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        }
        int sum = 0; // 넓이 합
        int max = 0; // 최대 넓이
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(stickers[i][0] + stickers[j][0] <= H && Math.max(stickers[i][1], stickers[j][1]) <= W ||
                        stickers[i][0] + stickers[j][0] <= W && Math.max(stickers[i][1], stickers[j][1]) <= H) {
                    sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
                }
                else if(stickers[i][0] + stickers[j][1] <= H && Math.max(stickers[i][1], stickers[j][0]) <= W ||
                        stickers[i][0] + stickers[j][1] <= W && Math.max(stickers[i][1], stickers[j][0]) <= H) {
                    sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
                }
                else if(stickers[i][1] + stickers[j][0] <= H && Math.max(stickers[i][0], stickers[j][1]) <= W ||
                        stickers[i][1] + stickers[j][0] <= W && Math.max(stickers[i][0], stickers[j][1]) <= H) {
                    sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
                }
                else if(stickers[i][1] + stickers[j][1] <= H && Math.max(stickers[i][0], stickers[j][0]) <= W ||
                        stickers[i][1] + stickers[j][1] <= W && Math.max(stickers[i][0], stickers[j][0]) <= H) {
                    sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
                }
                if(max < sum) max = sum;
            }
        }

        System.out.println(max);
    }
    public static void main(String[] args) throws IOException {
        getAnswer();
    }
}
