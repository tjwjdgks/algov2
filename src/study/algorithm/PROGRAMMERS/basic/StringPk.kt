package study.algorithm.PROGRAMMERS.basic

class StringPk {

    fun solution(my_string: String, index_list: IntArray): String {
        var answer: String = ""
        for(index in index_list){
            answer += my_string[index]
        }
        return answer
    }

    fun solution2(n: Int, control: String): Int {
        var answer: Int = n
        for(c in control){
            when(c){
                'w' -> answer = answer+1
                's' -> answer = answer-1
                'd' -> answer = answer+10
                'a' -> answer = answer-10
                else -> answer+0
            }
        }
        return answer
    }

    fun solution3(num_list: IntArray): IntArray {
        var answer = num_list.toMutableList()
        val lastNum = num_list.get(num_list.size-1)
        val lastSecondNum = num_list.get(num_list.size-2)
        if(lastNum > lastSecondNum){
            answer.add(lastNum - lastSecondNum)
        }
        else{
            answer.add(lastNum*2)
        }
        return answer.toIntArray()
    }
    fun solution4(num_list: IntArray): Int {
        var answer: Int = 0
        var oddString = ""
        var evenString = ""
        for(num in num_list){
            if(num%2 == 0) evenString += num
            else oddString += num
        }
        return oddString.toInt() + evenString.toInt()
    }

    fun solution5(num_list: IntArray): Int {
        var answer: Int = 0
        var mutlipleNum = 1
        var sumNum = 0
        for(num in num_list){
            mutlipleNum *= num
            sumNum += num
        }
        return if (mutlipleNum < sumNum*sumNum) 1 else 0
    }

}