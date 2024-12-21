package study.algorithm.PROGRAMMERS.basic

import kotlin.math.ceil
import kotlin.math.ln
import kotlin.math.pow

class Day20241221 {
    fun solution(number: String): Int {
        return number.map{ it.digitToInt() }.sum() % 9
    }

    fun solution2(a: Int, b: Int, c: Int): Int {
        if(a != b && b !=c && c!=a) {
            return a+b+c
        }
        else if(a == b && b == c){
            return ((a + b + c) * (pow(a, 2) + pow(b, 2) + pow(c, 2)) * (pow(a, 3) + pow(b, 3) + pow(c, 3))).toInt()
        }
        else{
            return ((a + b + c) * (pow(a, 2) + pow(b, 2) + pow(c, 2))).toInt()
        }
    }
    fun pow(target: Int, num: Int): Int{
        return target.toDouble().pow(num).toInt()
    }

    fun solution3(board: Array<IntArray>, k: Int): Int {
        var answer: Int = 0
        for(i in 0..board.size-1) {
            for(j in 0..board[0].size-1){
                if(i+j <= k) answer += board[i][j]
            }
        }
        return answer
    }

    fun solution4(myString: String): Array<String> {
        return myString.split("x").filter{!it.isEmpty()}.sorted().toTypedArray()
    }

    fun solution5(my_string: String, m: Int, c: Int): String {
        return my_string.filterIndexed {index, _ -> (index- (index/m)*m) == c-1 }
    }

    fun solution6(a: Int, d: Int, included: BooleanArray): Int {
        var answer: Int = 0
        for(i in included.indices){
            if(included[i]) answer += a + d*i
        }
        return answer
    }

    fun solution7(str1: String, str2: String): String {
        var answer: String = ""
        for(i in str1.indices){
            answer += str1[i] + "" + str2[i]
        }
        return answer
    }

    fun solution8(my_string: String, indices: IntArray): String {
        val sets = indices.toSet()
        return my_string.filterIndexed {index, _ -> !sets.contains(index)}
    }

    fun solution9(arr: IntArray, queries: Array<IntArray>): IntArray {
        for(i in queries){
            for(j in i[0]..i[1]){
                arr[j]++
            }
        }
        return arr
    }

    fun solution10(date1: IntArray, date2: IntArray): Int {
        return if(date1.joinToString("").compareTo(date2.joinToString(""))<0) 1 else 0
    }

    fun solution11(date1: IntArray, date2: IntArray): Int {
        return if(getDateToDay(date1) < getDateToDay(date2)) 1 else 0
    }
    fun getDateToDay(date: IntArray): Int {
        return date[0] * 365 + date[1] * 30 + date[2]
    }

    fun solution12(my_string: String): String {
        var answer: String = ""
        var sets = mutableSetOf<Char>()
        for(i in my_string){
            if(!sets.contains(i)){
                answer += i
                sets.add(i)
            }
        }
        return answer
    }

    fun solution13(arr: IntArray): IntArray {
        var answer = arr.toMutableList()
        var num = 0
        var sizes = arr.size
        while(sizes != 0) {
            num++
            sizes /= 2
        }
        val targetSize = 2.0.pow(num).toInt()
        if(targetSize/2 != arr.size) {
            repeat(targetSize - arr.size) { answer.add(0) }
        }

        return answer.toIntArray()
    }

    fun solution13_regular(arr: IntArray): IntArray {
        val len = arr.size
        var n = 1
        while (n < len) { n*=2 }
        return arr + IntArray(n-len){ 0 }
    }
    fun solution13_fancy1(arr: IntArray): IntArray {
        return arr.copyOf(2.0.pow(ceil(ln(arr.size.toDouble()) / ln(2.0))).toInt())
    }

    fun solution14(arr: IntArray, flag: BooleanArray): IntArray {
        val answer = ArrayDeque<Int>()
        // 원시 array zip의 경우 원시 Array 2개를 묶을 수 없음 한개는 toList로
        for((i, j) in arr.zip(flag.toList())){
            if(j){
                repeat(i*2){ answer.addLast(i) }
            }
            else{
                repeat(i) { answer.removeLast()}
            }
        }
        return answer.toIntArray()
    }

    fun solution15(myString: String, pat: String): Int {
        var answer: Int = 0
        var index = 0
        while(true){
            index = myString.indexOf(pat,index)
            if(index == -1) break
            index++
            answer++

        }
        return answer
    }
    fun solution16(myString: String, pat: String): String {
        return myString.substring(0, myString.lastIndexOf(pat)+pat.length)
    }

    fun solution17(num_list: IntArray): Int {
        var answer: Int = 0
        for(num in num_list){
            answer += toOneTotal(num)
        }
        return answer
    }
    fun toOneTotal(num: Int): Int{
        var currentNum = num
        var count = 0
        while(currentNum !=1){
            if(currentNum % 2 == 0) currentNum = currentNum /2
            else currentNum = (currentNum-1) /2
            count ++
        }
        return count
    }

    fun solution18(my_string: String, s: Int, e: Int): String {
        var answer: String =
            my_string.substring(0, s) + my_string.substring(s, e+1).reversed() + my_string.substring(e+1)
        return answer
    }
    fun solution19(intStrs: Array<String>, k: Int, s: Int, l: Int): IntArray {
        var answer = mutableListOf<Int>()
        for(i in intStrs){
            val currentNum = i.substring(s, s+l).toInt()
            if(k < currentNum) {
                answer.add(currentNum)
            }
        }
        return answer.toIntArray()
    }

    fun solution20(arr: IntArray, queries: Array<IntArray>): IntArray {
        for(querie in queries){
            val swapNum =arr[querie[0]]
            arr[querie[0]] = arr[querie[1]]
            arr[querie[1]] = swapNum
        }
        return arr
    }

}

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    println("${a} + ${b} = ${a+b}")
}