package study.algorithm.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoggleGame {
    public static String[] table;
    public static int[] dy = {-1,-1,-1,0,0,1,1,1};
    public static int[] dx = {-1,0,1,-1,1,-1,0,1};
    public static int [][][]cache;
    public static String word_g;
    // 실패 1 성공 2
    public static int dfs(int y, int x, int curstep, int step){
        if(curstep == step) {
            return 2;
        }
        if(cache[y][x][curstep] !=0) return cache[y][x][curstep];
        if(table[y].charAt(x) != word_g.charAt(curstep)) return cache[y][x][curstep] =1;

        for(int i=0;i<8;i++){
            int tempy = y+dy[i];
            int tempx = x+dx[i];
            if(tempy>=0 && tempy<5 && tempx>=0 && tempx<5){
                cache[y][x][curstep] = Math.max(cache[y][x][curstep],dfs(tempy,tempx,curstep+1,step));
            }
        }
        return cache[y][x][curstep];
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int t=0;t<N;t++){
            table = new String[5];
            for(int i=0;i<5;i++)
                table[i] = br.readLine();
            int count = Integer.parseInt(br.readLine());
            String [] words = new String[count];
            for(int i=0;i<count;i++){
                words[i] = br.readLine();
            }
            for(int i=0;i<count;i++){
                findWord(words[i],sb);
            }
        }
        System.out.print(sb.toString());
    }

    private static void findWord(String word,StringBuffer sb) {
        cache = new int[5][5][word.length()];
        word_g = word;
        int answer =0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                int dfs = dfs(i, j, 0, word.length());
                answer = Math.max(dfs,answer);
            }
        }
        if(answer == 2)
            sb.append(word+" YES\n");
        else
            sb.append(word+" NO\n");
    }
}
/*
4
URLPM
XPRET
GIAET
XTNZY
XOQRS
10
PRETTY
GIRL
REPEAT
KARA
PANDORA
GIAZAPX
REPEAT
KARA
PANDORA
URLPMPMPMM
NNNNS
NEEEN
NEYEN
NEEEN
NNNNN
4
YESR
SNNNNNNN
EEEEEEEEE
NEYN
NNNNN
NEEEN
NEYEN
NEEEN
NSNNN
1
YES
AAAAA
AAAAA
AAAAA
AAAAA
AAAAB
4
ABABABABAA
AAAAAAAAAB
ABABABABBA
BAAAAAAABA
 result
PRETTY YES
GIRL YES
REPEAT YES
KARA NO
PANDORA NO
GIAZAPX YES
REPEAT YES
KARA NO
PANDORA NO
URLPMPMPMM NO
YESR NO
SNNNNNNN YES
EEEEEEEEE YES
NEYN NO
YES YES
ABABABABAA YES
AAAAAAAAAB YES
ABABABABBA NO
BAAAAAAABA YES
 */