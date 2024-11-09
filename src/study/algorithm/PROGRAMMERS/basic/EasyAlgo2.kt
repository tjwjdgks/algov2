package study.algorithm.PROGRAMMERS.basic

class EasyAlgo2 {

    fun solution1(numLog: IntArray): String {
        var answer = ""
        var index = 0
        while(index < numLog.size-1) {
            val curNum = numLog[index]
            val nextNum = numLog[index+1]
            when(nextNum - curNum){
                1 -> answer += "w"
                -1 -> answer += "s"
                10 -> answer += "d"
                -10 -> answer += "a"
            }
            index++
        }
        return answer
    }

    fun solution1_fancy(numLog: IntArray): String {
        return (1..numLog.lastIndex).map {
            when (numLog[it] - numLog[it-1]) {
                1 -> 'w'
                -1 -> 's'
                10 -> 'd'
                else -> 'a'
            }
        }.joinToString("")
    }

    fun solution2(n: Int): Array<IntArray> {
        var answer: Array<IntArray> = Array<IntArray>(n){IntArray(n)}
        for(i in 0..n-1) {
            for(j in 0..n-1){
                if(i == j) answer[i][j] = 1
            }
        }
        return answer
    }

    fun solution2_fancy(n: Int) = Array(n) { i -> IntArray(n) { j -> if (i == j) 1 else 0 } }

    fun solution3(arr: Array<IntArray>): Int {
        var answer: Int = 1
        for(i in 0..arr.size-1){
            for(j in 0..arr.size-1){
                if(arr[i][j] != arr[j][i]) return 0
            }
        }
        return answer
    }

    fun solution4(n: Int): Int {
        return if(n % 2 == 0) getEvenTotal(n) else getOddTotal(n)
    }
    fun getEvenTotal(n: Int): Int {
        return (1..n).filter{it%2 == 0}.fold(0){total, num -> total+num*num }
    }
    fun getOddTotal(n: Int): Int {
        return (1..n).filter{it%2 == 1}.reduce{total, num -> total+num }

    }
    fun solution4(my_string: String, k: Int): String {
        return my_string.repeat(k)
    }

    fun solution5(binomial: String): Int {
        val strArray = binomial.split(" ")
        val firstNum = strArray[0].toInt()
        val secondNum = strArray[2].toInt()
        return when(strArray[1]) {
            "+" -> firstNum + secondNum
            "-" -> firstNum - secondNum
            "*" -> firstNum * secondNum
            else -> -1
        }
    }



}