package study.algorithm.PROGRAMMERS;

public class DartGame {
    public int solution(String dartResult) {
        int answer = 0;
        String[] arr = new String[3];
        int [] num_arr = new int[3];

        boolean check = true;
        int num_count = 0;
        int str_count = 0;
        String s = "";
        for(int i=0;i<dartResult.length();i++){
            if(check && Character.isDigit(dartResult.charAt(i))){
                s += dartResult.charAt(i);
            }
            else if(check && !Character.isDigit(dartResult.charAt(i))){
                int num = Integer.parseInt(s);
                num_arr[num_count++] = num;
                check = false;
                s = "";
                s += dartResult.charAt(i);
            }
            else if(!check && !Character.isDigit(dartResult.charAt(i))){
                s += dartResult.charAt(i);
            }
            else{
                arr[str_count++] = s;
                check= true;
                s = "";
                s += dartResult.charAt(i);
            }
        }
        arr[str_count++] = s;
        answer = calculate(num_arr, arr);
        return answer;
    }
    public int calculate(int[] num_arr, String[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i].charAt(0) == 'D'){
                num_arr[i] = num_arr[i] * num_arr[i];
            }
            else if(arr[i].charAt(0) == 'T'){
                num_arr[i] = num_arr[i] * num_arr[i] * num_arr[i];
            }

            if(arr[i].length() == 2 && arr[i].charAt(1) == '*'){
                num_arr[i] *=2;
                if(i-1>=0){
                    num_arr[i-1] *=2;
                }
            }
            else if(arr[i].length() ==2 && arr[i].charAt(1) == '#'){
                num_arr[i] = -num_arr[i];
            }
        }
        int answer = 0;
        for(int i=0;i<num_arr.length;i++){
            answer += num_arr[i];
        }
        return answer;

    }

}
