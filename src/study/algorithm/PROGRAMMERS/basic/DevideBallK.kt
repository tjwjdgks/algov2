package study.algorithm.PROGRAMMERS.basic

class DevideBallK {
    fun solution(balls: Int, share: Int): Long {
        var answer: Long = 1L
        var count: Int = 1
        var ball = balls
        while(count<=share){
            answer *= ball--
            answer /= count++
        }
        return answer
    }
}