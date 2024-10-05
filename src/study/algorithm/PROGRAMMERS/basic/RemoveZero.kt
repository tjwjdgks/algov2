package study.algorithm.PROGRAMMERS.basic

class RemoveZero {
    fun solution1(n_str: String): String {
        return n_str.replace("^0+".toRegex(), "")
    }
    fun solution2(n_str: String): String {
        return n_str
            .dropWhile { it == '0' }
    }
    fun solution3(nStr: String) = nStr.toInt().toString()

    fun solution4(n_str: String) = n_str.trimStart('0')


}