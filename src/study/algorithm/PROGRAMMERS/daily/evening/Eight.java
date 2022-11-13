package study.algorithm.PROGRAMMERS.daily.evening;

public class Eight {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int[] answer = new int[2];

        denum1 *= num2;
        denum2 *= num1;

        int val = denum1 + denum2;
        int valDenum = num1 * num2;
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i=2;i<valDenum;i++){
                if(val%i == 0 && valDenum%i == 0){
                    val = val/i;
                    valDenum = valDenum/i;
                    flag = true;
                    break;
                }
            }
            if(flag == false) break;
        }
        if(val%valDenum == 0){
            val = val/valDenum;
            valDenum = 1;
        }
        answer[0] = val;
        answer[1] = valDenum;
        return answer;
    }

}
