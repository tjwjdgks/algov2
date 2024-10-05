package study.algorithm.PROGRAMMERS.basic

class ToDaySolved {
    fun solution1(str1: String, str2: String): Int {
        return if (str2.contains(str1)) 1 else 0
    }
    fun solution2(num_list: IntArray): Int {
        var oddSum = 0
        var evenSum = 0
        num_list.forEachIndexed{
                indexed, num -> if(indexed %2 == 0) oddSum += num else evenSum += num
        }
        return Math.max(oddSum, evenSum)
    }
    fun solution3(my_string: String, target: String): Int {
        return if(my_string.contains(target)) 1 else 0
    }


}