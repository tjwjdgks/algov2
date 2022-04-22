package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ2644 {
    public Map<Integer,Integer> firstMap = new HashMap<>();
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] tree = new int[total+1];
        int totalRef = Integer.parseInt(br.readLine());
        for(int i=0;i<totalRef;i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[c] = p;
        }
        int count = 0;
        int index = n;
        firstMap.put(index,0);
        while(index != 0){
            firstMap.put(tree[index],++count);
            index = tree[index];
        }

        index = m;
        count = 0;
        if(firstMap.containsKey(m)){
            System.out.println(firstMap.get(m));
            return;
        }
        while(index != 0){
            if(tree[index]==0) break;
            count++;
            if(firstMap.containsKey(tree[index])){
                System.out.println(count+firstMap.get(tree[index]));
                return;
            }
            index = tree[index];
        }
        System.out.println(-1);
    }
}
