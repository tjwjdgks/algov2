package study.algorithm.PROGRAMMERS.basic

class Day20241224 {

    fun solution(array: IntArray, n: Int): Int {
        array.sort()
        var nearestNum = 0
        var gap = Int.MAX_VALUE
        for(num in array){
            if(nearestNum == num) continue
            val currentGap = Math.abs(num - n)
            if(gap <= currentGap) return nearestNum
            gap = currentGap
            nearestNum = num
        }
        return nearestNum
    }
    fun solution_fancy(array: IntArray, n: Int): Int =
        array.sortedWith(compareBy<Int> { Math.abs(it - n) }
            .thenBy { it })
            .first()

    fun solution2(strArr: Array<String>): Int {
        val groups = strArr.groupBy {it.length}
        var maxSize = 0
        for ((key, value) in groups) {
            maxSize = Math.max(maxSize, value.size)
        }
        return maxSize
    }

    fun solution2_fancy(strArr: Array<String>): Int {
        return strArr.groupBy { it.length }.maxOf { (k, v) -> v.size }
    }


}