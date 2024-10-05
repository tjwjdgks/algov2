package study.algorithm.PROGRAMMERS.basic

class PracticeZero {
    fun solution1(arr: IntArray, n: Int): IntArray {
        return arr.mapIndexed{index, num -> if(arr.size % 2 != 0){
            if(index%2 == 0) num+n else num
        } else {
            if(index%2 == 0) num else num+n
        }}.toIntArray()
    }

    fun solution2(n: Int): String {
        return n.toString()
    }

    fun solution3(n_str: String): Int {
        return n_str.toInt()
    }

    fun solution4(num_str: String): Int {
        var total = 0
        num_str.forEach{ it -> total += it - '0'}
        return total
    }

    fun solution4_fancy(num_str: String): Int {
        return num_str.map{ it.digitToInt() }.sum()
    }

    fun solution5(a: Int, b: Int): Int {
        return if(a%2 != 0 && b%2 != 0) return a*a + b*b
        else if(a%2 == 0 && b%2 == 0) return Math.abs(a-b)
        else 2*(a+b)
    }

    fun solution6(num_list: IntArray): IntArray {
        num_list.sort()
        var answer: IntArray = num_list.slice(0..4).toIntArray()
        return answer
    }

    fun solution6_fancy(num_list: IntArray): IntArray {
        return num_list.sorted().take(5).toIntArray()
    }

    fun solution7(arr: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        for(i in arr){
            for(k in 1..i){
                answer.add(i)
            }
        }
        return answer.toIntArray()
    }

    fun solution7_fancy(arr: IntArray): List<Int> {
        return arr.flatMap { i -> List(i) { i } }
    }

    fun solution8(myString: String, pat: String): Int {
        var replaceString = ""
        replaceString = myString.replace("A","C")
        replaceString = replaceString.replace("B", "A")
        replaceString = replaceString.replace("C", "B")
        return if(replaceString.contains(pat)) 1 else 0
    }

    fun solution8_fancy(myString: String, pat: String): Int {
        val result = myString.map { if (it == 'A') 'B' else 'A' }.joinToString("").indexOf(pat)
        return if (result >= 0) 1 else 0
    }

    fun solution9(myString: String): String {
        return myString.map{if(it < 'l') 'l' else it}.joinToString("")
    }

    fun solution10(n: Int): IntArray {
        val list = mutableListOf<Int>()
        solution10_dfs(n, list)
        return list.toIntArray()
    }
    fun solution10_dfs(n: Int, list: MutableList<Int>){
        list.add(n)
        if(n == 1) {
            return
        }
        if(n %2 == 0) solution10_dfs(n/2, list)
        else solution10_dfs(3*n+1, list)
    }
}