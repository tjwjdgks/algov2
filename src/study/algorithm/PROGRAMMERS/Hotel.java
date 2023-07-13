package study.algorithm.PROGRAMMERS;

public class Hotel {
    public int solution(String[][] book_time) {
        int N = book_time.length;
        int [][] time = new int[N][2];
        for(int i=0;i<N;i++){
            time[i][0] = getTime(book_time[i][0]);
            time[i][1] = getTime(book_time[i][1])+10;
        }
        int answer = 0;
        int [] count = new int[60*25];
        for(int i=0;i<N;i++){
            int startTime = time[i][0];
            int endTime = time[i][1];
            for(int j=startTime+1;j<=endTime;j++){
                count[j]++;
            }
        }
        for(int i : count){
            answer = Math.max(answer,i);
        }
        return answer;
    }
    public int getTime(String time){
        String[] split = time.split(":");
        return Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
    }
}
