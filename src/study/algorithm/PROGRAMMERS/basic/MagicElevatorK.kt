package study.algorithm.PROGRAMMERS.basic

class MagicElevatorK {
    fun solution(storeyNum: Int): Int {
        var storey = storeyNum
        var answer: Int = 0
        while(storey>0){
            var rest: Int = storey%10
            if(rest>5){
                answer += 10-rest
                storey = storey/10 +1
            }
            else if(rest<5){
                answer += rest
                storey = storey/10
            }
            else{
                answer += 5
                storey = storey/10
                if (storey%10 >= 5){
                    storey += 1
                }
            }
        }
        return answer
    }
}