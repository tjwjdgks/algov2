package study.algorithm.PROGRAMMERS.basic

class PracticeZero2 {
    fun solution1(my_string: String): Array<String> {
        return my_string.split(" ").filter{it.isNotEmpty()}.toTypedArray()
    }

    fun solution2(arr1: IntArray, arr2: IntArray): Int {
        return if(arr1.size != arr2.size){
            if(arr1.size > arr2.size) 1 else -1
        } else{
            val firstSum = arr1.sum()
            val secondSum = arr2.sum()
            if(firstSum == secondSum) 0
            else if(firstSum > secondSum) 1
            else -1
        }
    }
    fun solution3(rny_string: String): String {
        return rny_string.replace("m", "rn")
    }

    fun solution4(names: Array<String>): Array<String> {
        // chunked는 list에만 존재한다.
        var answer: Array<String> = names.toList().chunked(5).map{it->it.get(0)}.toTypedArray()
        return answer
    }

    fun solution5(myString: String): String {
        return myString.map{
            if(it == 'a') 'A'
            else if(it !='A') it.lowercaseChar()
            else it
        }.joinToString("")    }

    fun solution5_fancy(myString: String): String {
        return myString.lowercase().replace("a", "A")
    }
}