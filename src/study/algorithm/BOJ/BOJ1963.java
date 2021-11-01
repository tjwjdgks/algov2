package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1963 {

    public static int[] getDecimal4Range(){

        List<Integer> arr = new ArrayList<>();
        boolean [] check = new boolean[10001];
        for(int i=2;i<10000;i++){
            if(!check[i]){
                if(i>=1000)
                    arr.add(i);
                for(int j=i;j<10000;j+=i){
                    check[j] = true;
                }
            }
        }
        return arr.stream().mapToInt(i->i).toArray();
    }
    public static int getDiffNum(int num1, int num2){
        int diffCount = 0;
        for(int i=0;i<4;i++){
            int num1rest = num1%10;
            int num2rest = num2%10;
            if(num1rest!=num2rest) diffCount++;
            num1 /=10;
            num2 /=10;
        }
        return diffCount;
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] decimalArr = getDecimal4Range();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            boolean [] check = new boolean[decimalArr.length];

            queue.add(new int[]{start,0});
            int answer = -1;
            while(!queue.isEmpty()){
                int [] curnum = queue.poll();;
                if(curnum[0] == end){
                    answer = curnum[1];
                    break;
                }
                for(int j=0;j<decimalArr.length;j++){
                    if(check[j]) continue;
                    if(getDiffNum(curnum[0],decimalArr[j])==1){
                        check[j] = true;
                        queue.add(new int[]{decimalArr[j],curnum[1]+1});
                    }
                }
            }
            if(answer == -1)
                sb.append("Impossible").append("\n");
            else
                sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
