package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1065 {
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=1;i<=N;i++){
            if(isNum(i)) count++;
        }
        System.out.println(count);
    }

    private static boolean isNum(int num) {
        List<Integer> list = getList(num);
        int n = list.size();
        if(n == 1 || n == 2) return true;
        int gap = list.get(0) - list.get(1);
        for(int i=1;i<list.size()-1;i++){
            if(list.get(i) - list.get(i+1) != gap) return false;
        }
        return true;
    }

    private static List<Integer> getList(int i) {
        List<Integer> list = new ArrayList<>();
        while(i !=0){
            int rest = i%10;
            list.add(rest);
            i /=10;
        }
        return list;
    }
}
