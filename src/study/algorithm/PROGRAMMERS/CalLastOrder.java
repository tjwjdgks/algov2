package study.algorithm.PROGRAMMERS;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CalLastOrder {
    public Map<String,Integer> foodMap = new HashMap<>();
    public int solution(int n, String[] recipes, String[] orders) {
        int answer = 0;
        makeFoodMap(recipes);
        answer = calculateTotalTime(n,orders);
        return answer;
    }
    private void makeFoodMap(String[] recipes){
        for(String recipe : recipes){
            String[] arr = recipe.split(" ");
            String food = arr[0];
            int makeTime = Integer.parseInt(arr[1]);
            foodMap.put(food,makeTime);
        }
    }
    private int calculateTotalTime(int maxSize,String[] orders) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0]-o2[0];
        });
        int currentSize = 0;
        int countIdx=0;
        for(String order : orders){
            String[] arr = order.split(" ");
            String foodname = arr[0];
            int currentTime = Integer.parseInt(arr[1]);
            if(currentSize<maxSize){
                pq.add(new int[]{currentTime+foodMap.get(foodname),countIdx});
                currentSize++;
            }
            else{
                int [] preFood = pq.poll();
                int nextTime = Math.max(preFood[0],currentTime);
                pq.add(new int[]{nextTime+foodMap.get(foodname),countIdx});
            }
            countIdx++;
        }
        int finalTime = 0;
        while(!pq.isEmpty()){
            int[] curFood = pq.poll();
            if(curFood[1] == orders.length-1) finalTime = curFood[0];
        }
        return finalTime;
    }
}
