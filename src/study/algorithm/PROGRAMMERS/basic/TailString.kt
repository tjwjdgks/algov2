package study.algorithm.PROGRAMMERS.basic

class TailString {
    fun solution(str_list: Array<String>, ex: String): String {
        // joinToString의 deafult는 "," 구분자가 들어가므로 ""로 만들어준다
        return str_list.filter{ !it.contains(ex) }.joinToString("")
    }
}