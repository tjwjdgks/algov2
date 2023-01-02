package study.algorithm.PROGRAMMERS.daily.evening;

public class Sixteen {
    public String[] solution(String[] quiz) {

        String[] answer = new String[quiz.length];

        int count = 0;
        for(String s : quiz){

            String [] s_arr = s.split(" ");
            int firstNum = Integer.parseInt(s_arr[0]);
            int secondNum = Integer.parseInt(s_arr[2]);
            int totalNum = 0;
            if(s_arr[1].equals("-")){
                totalNum = firstNum - secondNum;
            }
            else{
                totalNum = firstNum + secondNum;
            }

            int answerNum = Integer.parseInt(s_arr[4]);

            if(totalNum == answerNum){
                answer[count++] = "O";
            }
            else{
                answer[count++] = "X";
            }

        }

        return answer;
    }
}
