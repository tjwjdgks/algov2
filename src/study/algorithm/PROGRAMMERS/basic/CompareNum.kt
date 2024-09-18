package study.algorithm.PROGRAMMERS.basic

import kotlin.math.*
class CompareNum {
    fun solution(a: Int, b: Int): Int {
        val cal1 = (a.toString()+b.toString()).toInt()
        val cal2 = 2*a*b
        var answer: Int = Math.max(cal1,cal2)
        return answer
    }
    fun solution2(a: Int, b: Int): Int {
        return max("$a$b".toInt(), "$b$a".toInt())
    }

    fun solution3(arr: Array<String>): String {
        var answer: String = arr.joinToString("")
        return answer
    }
    fun solution4() {
        var a = readLine()!!.toInt()
        if(a%2 == 0){
            print("$a is even")
        }
        else{
            print("$a is odd")
        }
    }
    fun solution5(arr: IntArray, delete_list: IntArray): IntArray {
        var answer: IntArray = arr.filter{it -> !delete_list.contains(it)}.toIntArray()
        return answer
    }
}