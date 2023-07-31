package study.algorithm.PROGRAMMERS;

public class AirCon {
    public int [][][] dp;
    public int[] onboard_g;
    public int t1_g, t2_g;
    public int a_g, b_g;
    public int temp_g;
    public int dfs(int step, int temperature, int onOff, int cost){
        if(step == onboard_g.length) return cost;
        if(!isIn(temperature,0, 50)) return Integer.MAX_VALUE;
        if(dp[step][temperature][onOff] != 0) return dp[step][temperature][onOff];
        if(onboard_g[step] == 1 && !isIn(temperature,t1_g, t2_g)){
            dp[step][temperature][onOff] = Integer.MAX_VALUE;
            return dp[step][temperature][onOff];
        }
        int curCost = Integer.MAX_VALUE;
        curCost = Math.min(curCost, dfs(step+1, getNextTemp(temperature), 0, cost));
        curCost = Math.min(curCost, dfs(step+1, temperature, 1, cost+b_g));
        curCost = Math.min(curCost, dfs(step+1, temperature-1, 1, cost+a_g));
        curCost = Math.min(curCost, dfs(step+1, temperature+1, 1, cost+a_g));

        dp[step][temperature][onOff] = curCost;
        return dp[step][temperature][onOff];
    }
    public boolean isIn(int temperature, int start, int end){
        return temperature >= start && temperature <= end;
    }
    public int getNextTemp(int temperature){
        int nextTemp = temperature;
        if(temperature > temp_g){
            nextTemp -=1;
        }
        if(temperature < temp_g){
            nextTemp += 1;
        }
        return nextTemp;
    }
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int answer = 0;
        t1_g = t1+10;
        t2_g = t2+10;
        a_g = a;
        b_g = b;
        onboard_g = onboard;
        temp_g = temperature+10;
        dp = new int[onboard.length][51][2];
        answer = dfs(0,temperature+10, 0, 0);
        return answer;
    }
    public static void main(String [] args){
        AirCon a = new AirCon();
        a.solution(28, 18, 26, 10, 8, new int[]{0, 0, 1, 1, 1, 1, 1});
    }
}
