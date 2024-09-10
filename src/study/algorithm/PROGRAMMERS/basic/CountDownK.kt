package study.algorithm.PROGRAMMERS.basic

class CountDownK {

    fun solution(start_num: Int, end_num: Int): IntArray {
        var answer: IntArray = IntArray(start_num - end_num+1) { i -> start_num - i }
        return answer
    }
    fun solution2(n: Int, k: Int): IntArray {
        var answer: IntArray = IntArray(n/k){i-> (i+1)*k}
        return answer
    }
    fun solution3(my_string: String, is_prefix: String): Int {
        var answer: Int = if(my_string.startsWith(is_prefix)) 1 else 0
        return answer
    }

    fun solution4(){
        val input = readLine()!!.split(' ')
        val s1 = input[0]
        val s2 = input[1]
        println(s1+s2)
    }
    fun solution5(my_string: String, n: Int): String {
        var answer: String = my_string.substring(0,n)
        return answer
    }

    fun solution6(my_string: String, is_suffix: String): Int {
        var answer: Int = if(my_string.endsWith(is_suffix)) 1 else 0
        return answer
    }

    fun solution7(my_strings: Array<String>, parts: Array<IntArray>): String {
        var answer: String = ""
        for(pair in (my_strings zip parts)){
            answer += pair.first.substring(pair.second[0], pair.second[1]+1)
        }
        return answer
    }



}