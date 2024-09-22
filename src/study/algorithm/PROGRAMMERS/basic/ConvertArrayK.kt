package study.algorithm.PROGRAMMERS.basic

class ConvertArrayK {

    fun solution(arr: IntArray, k: Int): IntArray {
        var answer: IntArray = arr.map{i -> if(k%2 !=0) i*k else i+k}.toIntArray()
        return answer
    }
}