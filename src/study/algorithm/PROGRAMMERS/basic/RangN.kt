package study.algorithm.PROGRAMMERS.basic

class RangN {
    fun solution(num_list: IntArray, n: Int): IntArray {
        var answer: IntArray = num_list.filterIndexed{index, num -> index<n}.toIntArray()
        return answer
    }
}