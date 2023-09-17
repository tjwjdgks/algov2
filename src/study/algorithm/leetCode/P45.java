package study.algorithm.leetCode;

import java.util.*;
public class P45 {
    public int jump(int[] nums) {
        int [] checks = new int[nums.length];
        Arrays.fill(checks, -1);
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        // index, count
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int [] index = queue.poll();
            if(index[0] == nums.length-1) return index[1];
            for(int i=index[0];i<=index[0]+nums[index[0]];i++){
                if(i >= nums.length) break;
                if(checks[i] == -1){
                    checks[i] = index[1]+1;
                    queue.add(new int[]{i, index[1]+1});
                }
            }
        }
        return count;
    }
}