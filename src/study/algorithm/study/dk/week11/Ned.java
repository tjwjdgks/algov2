package study.algorithm.study.dk.week11;

public class Ned {
    public int solution(int[] queue1, int[] queue2) {
        int firstLength = queue1.length;
        int secondLength = queue2.length;

        long total = 0;
        long firstQueueTotal = 0;
        long secondQueueTotal = 0;
        for(int i : queue1){
            total += i;
            firstQueueTotal += i;
        }

        for(int i : queue2){
            total += i;
            secondQueueTotal += i;
        }
        if(total%2 == 1) return -1;
        int firstCount = getMinCount(queue1,queue2,firstQueueTotal,total/2);
        int secondCount = getMinCount(queue2,queue1,secondQueueTotal,total/2);
        int answer = Math.min(firstCount,secondCount);
        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }

    public int getMinCount(int[] stand, int[] target,long queueTotal, long mid){
        boolean firstFlag = true;
        int firstIndex = 0;
        int lastIndex = 0;
        long curTotal = queueTotal;
        int count =0;
        while(true){
            while(curTotal<mid){
                if(lastIndex == target.length) return Integer.MAX_VALUE;
                curTotal += target[lastIndex++];
                count++;
            }
            while(curTotal>mid){
                if(firstFlag == false){
                    if(firstIndex == target.length) return Integer.MAX_VALUE;
                    curTotal -= target[firstIndex++];
                }
                else{
                    curTotal -= stand[firstIndex++];
                    if(firstIndex == stand.length){
                        firstIndex=0;
                        firstFlag = false;
                    }
                }
                count++;
            }
            if(curTotal == mid){
                return count;
            }
        }
    }
    public static void main(String []args){
        Ned n = new Ned();
        int solution = n.solution(new int[]{1,1}, new int[]{1,5});
        System.out.println(solution);

    }
}
