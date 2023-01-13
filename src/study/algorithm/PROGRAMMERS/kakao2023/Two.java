package study.algorithm.PROGRAMMERS.kakao2023;

public class Two {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer  = 0;

        int deliveryCount =  0;
        int pickupsCount = 0;

        int sizeIndex = deliveries.length-1;
        int deliveryIndex = sizeIndex;
        int pickupIndex =  sizeIndex;

        for(int i= sizeIndex;i>=0;i--){
            if(deliveries[i] == 0 && pickups[i] == 0 ) continue;

            long totalCount = 0;
            long val = 0;
            long rest = 0;
            if(deliveries[i]>=pickups[i]){
                rest = deliveries[i] % cap;
                val = rest== 0 ? deliveries[i]/cap : deliveries[i]/cap +1;
            }
            else{
                rest = pickups[i] % cap;
                val = rest == 0 ? pickups[i]/cap : pickups[i]/cap +1;
            }
            totalCount = val*cap;
            answer += (i+1) * val * 2;
            deliveryIndex = doMinus(deliveryIndex,totalCount, deliveries);
            pickupIndex = doMinus(pickupIndex,totalCount,pickups);
        }
        return answer;
    }
    public int doMinus(int index, long totalCount, int[] array){
        if(index == -1 ) return -1;

        for(int i=index;i>=0;i--){
            if(array[i] > totalCount){
                array[i] -= totalCount;
                return i;
            }
            totalCount -= array[i];
            array[i] = 0;
        }

        return -1;
    }
}
