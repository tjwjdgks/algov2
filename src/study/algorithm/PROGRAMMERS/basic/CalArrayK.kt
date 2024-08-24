package study.algorithm.PROGRAMMERS.basic

class CalArrayK {
    fun solution(num_list: IntArray): Int {
        var answer: Int = if (num_list.size >= 11) num_list.sum() else num_list.reduce{num1, num2 -> num1*num2}
        return answer
    }
}