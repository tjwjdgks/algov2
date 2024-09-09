package study.algorithm.PROGRAMMERS.basic

class RangeLimitN {
    fun solution(num_list: IntArray, n: Int): IntArray {
        var answer: IntArray = num_list.filterIndexed{index, num -> index>=n-1}.toIntArray()
        return answer
    }
}