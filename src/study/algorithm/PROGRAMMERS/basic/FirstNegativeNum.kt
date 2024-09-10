package study.algorithm.PROGRAMMERS.basic

class FirstNegativeNum {
    fun solution(num_list: IntArray): Int {
        num_list.forEachIndexed { index, num -> if(num<0) return index }
        return -1
    }

    fun solution2(num_list: IntArray): Int {
        return num_list.indexOfFirst { it < 0 }
    }
}