package study.algorithm.PROGRAMMERS;

public class deliveryGoldAndSilver {
    public int a,b;
    public long solution(int _a, int _b, int[] g, int[] s, int[] w, int[] t) {

        a = _a;
        b = _b;

        int n = w.length;

        long answer = -1;
        long minTime = 0;
        long maxTime = (long)1e15;

        while(minTime<maxTime){
            long midTime = (minTime+maxTime)/2;
            if(check(n,midTime,g,s,w,t))
                maxTime = midTime;
            else
                minTime=midTime+1;
        }
        answer = minTime;
        return answer;
    }
    public boolean check(int n, long midTime,int[] g, int[] s, int[] w, int[] t){
        long total=0, totalGlod=0, totalSilver=0;
        for(int i=0;i<n;i++){
            long curCount = (midTime+t[i])/(2*t[i]);
            long curTotalWeight = curCount*w[i];

            totalGlod += (g[i]<curTotalWeight)? g[i] : curTotalWeight;
            totalSilver += (s[i]<curTotalWeight)? s[i] : curTotalWeight;
            total += (g[i]+s[i]<curTotalWeight)? g[i]+s[i] : curTotalWeight;
        }
        if(totalGlod >= a && totalSilver >= b && total >= a+b)
            return true;

        else return false;

    }
}

