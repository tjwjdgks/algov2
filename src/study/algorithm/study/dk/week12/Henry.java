package study.algorithm.study.dk.week12;

public class Henry {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int [] array = new int[e+1];
        for(int i=1;i<=e;i++){
            for(int j=1;j<=e;j++){
                if(i*j>e) break;
                array[i*j] +=1;
            }
        }
        int max =0;
        int maxIndex = e;
        int [] arrayIndex = new int[e+1];
        for(int i=e;i>=1; i--){
            if(array[i]>=max){
                maxIndex = i;
                max = array[i];
            }
            arrayIndex[i] = maxIndex;
        }
        for(int i=0;i< starts.length;i++){
            answer[i] = arrayIndex[starts[i]];
        }
        return answer;
    }
    public static void main(String [] args){
        Henry h = new Henry();
        h.solution(8, new int[]{1, 3, 7});
    }
}
