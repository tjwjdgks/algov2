package study.algorithm.PROGRAMMERS;

public class zipString {
    public int solution(String s) {
        int answer = 0;
        answer = s.length();
        for(int i=1;i<=s.length()/2;i++){
            int total =0;
            String before = "";
            int count = 1;
            for(int j=0;j<s.length();j+=i){
                String sub = j+i <=s.length()? s.substring(j,j+i) : s.substring(j);
                if(before.equals(sub)){
                    count++;
                }
                else{
                    before = sub;
                    if(count !=1){
                        total += Math.log10(count) +1;
                    }
                    total += before.length();
                    count  = 1;
                }
            }
            total += before.length();
            if(count != 1){
                total += Math.log10(count)+1;
            }
            answer = Math.min(answer,total);
        }
        return answer;
    }
}
