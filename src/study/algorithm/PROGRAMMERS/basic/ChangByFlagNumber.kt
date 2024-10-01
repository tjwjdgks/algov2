package study.algorithm.PROGRAMMERS.basic

class ChangByFlagNumber {
    fun solution(a: Int, b: Int, flag: Boolean): Int {
        return if(flag) a+b else a-b
    }

}