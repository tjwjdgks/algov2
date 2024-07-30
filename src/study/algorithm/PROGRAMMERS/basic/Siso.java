package study.algorithm.PROGRAMMERS.basic;

import java.util.HashMap;
import java.util.Map;

public class Siso {
    public Long solution(int[] weights) {
        Long answer = 0L;
        Map<Long, Long> torqueMap = new HashMap<>();
        Map<Long, Long> weightCount = new HashMap<>();
        for (long weight : weights) {
            weightCount.put(weight, weightCount.getOrDefault(weight, 0L) + 1);
            Long[] torques = {weight * 2, weight * 3, weight * 4};
            for (Long torque : torques) {
                torqueMap.put(torque, torqueMap.getOrDefault(torque, 0L) + 1);
            }
        }

        for (Long count : torqueMap.values()) {
            if (count > 1) {
                answer += (Long) count * (count - 1) / 2;
            }
        }


        Long minus = 0L;
        for (Long count : weightCount.values()) {
            if(count > 1){
                minus+= ((Long) count * (count - 1) / 2)*2;
            }
        }

        return answer - minus;
    }
}
