package study.algorithm.PROGRAMMERS.daily.launch;


import java.util.Stack;

public class Six {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<ingredient.length;i++){
            stack.push(ingredient[i]);
            if(ingredient[i] == 1){
                answer += makeBurger(stack);
            }
        }
        return answer;
    }
    public int[] array_r = {1,3,2,1};
    public int makeBurger(Stack<Integer> stack){
        boolean check = true;
        int count = 0;
        Stack<Integer> curStack = new Stack<>();
        while(!stack.isEmpty() && count <4){
            int curNum = stack.pop();
            if(curNum != array_r[count]){
                check = false;
                curStack.push(curNum);
                break;
            }
            curStack.add(curNum);
            count++;
        }
        if(check && count ==4) return 1;
        while(!curStack.isEmpty()){
            stack.push(curStack.pop());
        }
        return 0;
    }

}
