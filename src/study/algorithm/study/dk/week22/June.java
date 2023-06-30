package study.algorithm.study.dk.week22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class June {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        final int index = col-1;
        row_begin = row_begin-1;
        row_end = row_end-1;
        Arrays.sort(data, (o1,o2) ->{
            if(o1[index] == o2[index]){
                return o2[0] - o1[0];
            }
            return o1[index] - o2[index];
        });
        List<Integer> list = new ArrayList<>();
        for(int i=row_begin;i<=row_end;i++){
            int total = 0;
            for(int j=0;j<data[i].length;j++){
                total += data[i][j] % (i+1);

            }
            list.add(total);
        }
        int answer = list.get(0);
        for(int i=1;i<list.size();i++){
            answer = answer ^ list.get(i);
        }
        return answer;
    }
}
