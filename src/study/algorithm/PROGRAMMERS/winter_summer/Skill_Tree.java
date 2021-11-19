package study.algorithm.PROGRAMMERS.winter_summer;

public class Skill_Tree {
    public int solution(String skill, String[] skill_trees) {
        int answer = -1;
        for(String tree : skill_trees){
            boolean flag = true;
            for(int i=0;i<skill.length()-1;i++){
                int curnum = tree.indexOf(skill.charAt(i));
                int nextnum = tree.indexOf(skill.charAt(i+1));
                if(nextnum == -1) continue;
                if(curnum == -1) curnum = Integer.MAX_VALUE;
                if(curnum>nextnum){
                    flag = false;
                    break;
                }
            }
            if(flag)
                answer++;
        }
        return answer;
    }
}
