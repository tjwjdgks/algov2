package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2422 {
    public final int END_STEP = 3;
    public int answer = 0;
    public int N,M;
    public Map<String, Set<String>> map = new HashMap<>();
    public void dfs(int step, int index, Stack<String> n){
        if(step == END_STEP){
            if(isPossible(n)){
                answer++;
            }
            return;
        }
        for(int i= index+1;i<=N;i++){
            n.push(Integer.toString(i));
            dfs(step+1,i,n);
            n.pop();
        }
    }

    private boolean isPossible(Stack<String> n) {
        String[] arr = n.toArray(new String[0]);
        return checkVal(arr[0],arr[1],arr[2]) && checkVal(arr[1],arr[2],arr[0]) && checkVal(arr[2],arr[1],arr[0]);
    }

    private boolean checkVal(String s, String s1, String s2) {
        if(map.containsKey(s) == false) return true;
        return !map.get(s).contains(s1) && !map.get(s).contains(s2);
    }

    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();
            add(first,second);
            add(second,first);
        }
        dfs(0,0,new Stack<>());
        System.out.println(answer);
    }

    private void add(String key, String value) {
        if(!map.containsKey(key)){
            map.put(key, new HashSet<>());
        }
        map.get(key).add(value);
    }
}
