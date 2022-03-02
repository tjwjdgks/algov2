package study.algorithm.PROGRAMMERS.kakao2022;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class four {
    public static int [] info_g;
    public static int [] list_g = new int[11];
    public static boolean canWin = false;
    public static int maxNum = 0;
    public void dfs(int count, int idx, int [] list){
        if(idx == 11){
            if(count>0){
                list[idx-1] = count;
            }
            int curNum = cal(list,info_g);
            if(maxNum < curNum){
                canWin = true;
                maxNum = curNum;
                list_g = list.clone();
            }
            else if(maxNum == curNum){
                list_g = selectArr(list, list_g);
            }
            list[idx-1] = 0;
            return;
        }

        if(info_g[idx]+1<= count){
            list[idx] = info_g[idx]+1;
            dfs(count-info_g[idx]-1,idx+1, list);
            list[idx] = 0;
        }
        dfs(count,idx+1,list);

    }

    private int[] selectArr(int[] list, int[] list_g) {

        for(int i=list.length-1;i>=0;i--){
            if(list[i] > list_g[i]) return list.clone();
            if(list[i] < list_g[i]) return list_g;
        }
        return list;
    }

    private int cal(int[] list, int[] info_g) {
        int infoNum = 0;
        int answerNum = 0;
        for(int i=0;i< info_g.length;i++){
            if(list[i]>info_g[i]){
                answerNum += 10-i;
            }
            else{
                if(info_g[i] == 0 ) continue;
                infoNum += 10-i;
            }
        }
        return answerNum - infoNum;
    }

    public int[] solution(int n, int[] info) {
        info_g = info;
        int [] check = new int[11];
        dfs(n,0, check);

        if(canWin){
            return list_g;
        }
        else return new int[]{-1};
    }
}
