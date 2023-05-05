package study.algorithm.study.dk.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sherlock {

    public static List<int[]> chickenArray;
    public static List<int[]> cityArray;

    public static int minDistance = Integer.MAX_VALUE;
    public static void dfs(Deque<Integer> list, int selectCount, int start){
        if(selectCount == list.size()){
            minDistance = Math.min(minDistance, calDistance(list));
            return;
        }
        for(int i=start+1;i<chickenArray.size(); i++){
            list.add(i);
            dfs(list,selectCount,i);
            list.pollLast();
        }
    }

    private static int calDistance(Deque<Integer> list) {
        int answer = 0;
        for(int [] i : cityArray){
            int minCurCityDistance = Integer.MAX_VALUE;
            for(int l  : list){
                int[] curChickenIndex = chickenArray.get(l);
                minCurCityDistance = Math.min(minCurCityDistance, Math.abs(i[0]-curChickenIndex[0])+Math.abs(i[1]-curChickenIndex[1]));
            }
            answer += minCurCityDistance;
        }
        return answer;
    }

    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] arr = new int[N][];
        for(int i=0;i<N;i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        }
        chickenArray = new ArrayList<>();
        cityArray = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j] == 2){
                    chickenArray.add(new int[]{i,j});
                } else if(arr[i][j] == 1){
                    cityArray.add(new int[]{i,j});
                }
            }
        }
        Deque<Integer> list = new ArrayDeque<>();
        dfs(list,M,-1);
        System.out.println(minDistance);
    }
    public static void main(String []args) throws IOException {
        getAnswer();
    }
}
