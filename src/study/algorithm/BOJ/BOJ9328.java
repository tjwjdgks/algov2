package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ9328 {
    public static int[] dy = new int[]{0,0,-1,1};
    public static int[] dx = new int[]{1,-1,0,0};

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T =  Integer.parseInt(br.readLine());
        for(int i = 0; i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String [] arr = new String[N+2];
            char[] tempArrr = new char[M+2];
            Arrays.fill(tempArrr,'.');
            arr[0] = new String(tempArrr);
            arr[N+1] = new String(tempArrr);
            for(int k=1;k<=N; k++){
                String ts  = br.readLine();
                arr[k] = "."+ts+".";
            }
            String keys = br.readLine();
            int curanswer = getMaxDocs(N+2,M+2,arr,keys);
            sb.append(curanswer).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static int getMaxDocs(int N, int M, String [] table, String initKey){
        int answer = 0;
        Set<Character> set;
        if(initKey.equals("0"))
            set = new HashSet<>();
        else
            set = initKey.chars().mapToObj(i->(char)i).collect(Collectors.toSet());

        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> restQueue = new LinkedList<>();
        boolean [][] checks = new boolean[N][M];

        checks[0][0] = true;
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] curidx = queue.poll();
            char targetChar = table[curidx[0]].charAt(curidx[1]);
            if(targetChar == '$')
                answer++;
            else if(targetChar>='a' && targetChar<='z'){
                Queue<int[]> tempqueue = new LinkedList<>();
                while(!restQueue.isEmpty()){
                    int[] ridx = restQueue.poll();
                    char rchar = table[ridx[0]].charAt(ridx[1]);
                    if(Character.toLowerCase(rchar) == targetChar)
                        queue.add(ridx);
                    else
                        tempqueue.add(ridx);
                }
                restQueue = tempqueue;
            }
            for(int i=0;i<4;i++){
                int tempy = curidx[0] + dy[i];
                int tempx = curidx[1] + dx[i];
                if(tempy>=0 && tempy<N&& tempx>=0 && tempx<M){
                    if(checks[tempy][tempx]) continue;
                    checks[tempy][tempx] = true;
                    char tempchar = table[tempy].charAt(tempx);
                    if(tempchar == '.')
                        queue.add(new int[]{tempy,tempx});
                    else if(tempchar >='a' && tempchar<='z'){
                        queue.add(new int[]{tempy,tempx});
                        set.add(tempchar);
                    }
                    else if(tempchar >= 'A' && tempchar <='Z'){
                        if(set.contains(Character.toLowerCase(tempchar)))
                            queue.add(new int[]{tempy,tempx});
                        else
                            restQueue.add(new int[]{tempy,tempx});
                    }
                    else if(tempchar == '$')
                        queue.add(new int[]{tempy,tempx});
                }
            }
        }
        return answer;
    }
}
