package study.algorithm.PROGRAMMERS

import java.util.*

class ChangePractice{

    fun solution1(my_string: String, alp: String): String {
        return my_string.replace(alp, alp.uppercase(Locale.getDefault()))
    }

    fun solution2(strArr: Array<String>): Array<String> {
        return strArr.mapIndexed {
                index, str -> if(index%2==0) str.lowercase(Locale.getDefault()) else str.uppercase(Locale.getDefault())
        }.toTypedArray()

    }
    fun solution3(myString: String, pat: String): Int {
        return if(myString.contains(pat, true)) 1 else 0
    }
    fun solution4(myString: String): String {
        return myString.lowercase()
    }

    fun solution5(myString: String): IntArray {
        return myString.split("x").map{it -> it.length}.toIntArray()

    }
}