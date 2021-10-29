package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair{
    int first, second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
public class BOJ2250 {
    public static int[] minArr;
    public static int[] maxArr;
    public static Pair[] pair;
    public static int [] numArr;
    public static int numCount=1;
    public static void dfs(int step, int level){
        if(pair[step].first >0)
            dfs(pair[step].first,level+1);

        minArr[level] = Math.min(numCount,minArr[level]);
        maxArr[level] = Math.max(maxArr[level],numCount++);

        if(pair[step].second>0)
            dfs(pair[step].second,level+1);
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        minArr = new int[N+1];
        numArr = new int[N+1];
        Arrays.fill(minArr,Integer.MAX_VALUE);
        maxArr = new int[N+1];
        pair = new Pair[N+1];
        int root = 0;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int firstC = Integer.parseInt(st.nextToken());
            int secondC = Integer.parseInt(st.nextToken());

            numArr[parent]++;
            pair[parent] = new Pair(firstC,secondC);
            if(firstC!=-1)
                numArr[firstC]++;
            if(secondC!=-1)
                numArr[secondC]++;
        }
        for(int i=1;i<=N;i++){
            if(numArr[i] == 1){
                root = i;
                break;
            }
        }
        dfs(root,1);
        int result = maxArr[1]-minArr[1]+1;
        int level = 1;
        for(int i=2;i<=N;i++){
            int tempResult = maxArr[i]-minArr[i]+1;
            if(tempResult>result){
                result = tempResult;
                level  = i;
            }
        }
        System.out.println(level+" "+result);
    }
}
