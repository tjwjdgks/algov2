package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ1068 {
    public static int[] tree;
    public static void dfs(int removeIndex){
        tree[removeIndex] = -2;
        for(int i=0;i<tree.length;i++){
            if(tree[i] == removeIndex)
                dfs(i);
        }
    }
    public static void getAnswer() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = Arrays.stream(br.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        int remove = Integer.parseInt(br.readLine());
        dfs(remove);
        List<Integer> edge = getEdge();
        System.out.println(edge.size());

    }

    private static List<Integer> getEdge() {
        List<Integer> edge = new ArrayList<>();
        int [] count = new int[tree.length];
        for(int i=0;i<tree.length;i++){
            if(tree[i] == -1) continue;
            if(tree[i]== -2 ){
                count[i] = 1;
            }
            else count[tree[i]]++;
        }
        for(int i=0;i<tree.length;i++){
            if(count[i] == 0) edge.add(i);
        }
        return edge;
    }
}
