package study.algorithm.PROGRAMMERS.basic

class Day20241225 {
    fun solution(i: Int, j: Int, k: Int): Int {
        var answer: Int = 0
        (i..j).forEach { answer += it.toString().count{c -> c == k.digitToChar()} }
        return answer
    }
    fun solution2(myStr: String): Array<String> {
        // string 정규식으로 분리하려면 toRegex 사용
        val split = myStr.split("[abc]".toRegex()).filter{it -> !it.isEmpty()}
        return if(split.isEmpty()) arrayOf<String>("EMPTY") else split.toTypedArray()
    }

    fun solution3(x1: Boolean, x2: Boolean, x3: Boolean, x4: Boolean): Boolean {
        return (x1 || x2) && (x3 || x4)
    }

    fun solution4(arr: IntArray): IntArray {
        val start = arr.indexOfFirst{ it == 2 }
        val end = arr.indexOfLast { it == 2}
        return if(start == -1) intArrayOf(-1) else arr.slice(start..end).toIntArray()
    }

    fun solution5(before: String, after: String): Int {
        var targetString = after
        before.forEach {
            targetString = targetString.replaceFirst(it.toString(),"")
        }
        return if(targetString.isEmpty()) 1 else 0
    }

    fun solution5_fancy(before: String, after: String): Int =
        if (before.toList().sorted() == after.toList().sorted()) 1 else 0

    fun solution6(n: Int, slicer: IntArray, num_list: IntArray): IntArray {
        when(n){
            1 -> return num_list.slice(0..slicer[1]).toIntArray()
            2 -> return num_list.slice(slicer[0]..num_list.size-1).toIntArray()
            3 -> return num_list.slice(slicer[0]..slicer[1]).toIntArray()
            4 -> return num_list.slice(slicer[0]..slicer[1] step slicer[2]).toIntArray()
            else -> return intArrayOf(-1)
        }
    }

    fun solution7(s: String): Int {
        val commands = s.split(" ")
        var answer: Int = 0
        var beforeNum: Int = 0
        for(command in commands){
            if(command == "Z") {
                answer -= beforeNum
            }
            else{
                beforeNum = command.toInt()
                answer += beforeNum
            }
        }
        return answer
    }

    fun solution8(arr: IntArray): Int {
        var answer: Int = 0
        for(num in arr){
            answer = Math.max(answer, getMinSameNumCount(num))
        }
        return answer
    }
    fun getMinSameNumCount(num: Int): Int {
        var count = 0
        var currentNum = num
        while(true){
            if(currentNum >= 50 && currentNum % 2 == 0) {
                currentNum /= 2
            }
            else if(currentNum < 50 && currentNum % 2 == 1) {
                currentNum = currentNum * 2 + 1
            }
            else break
            count++
        }
        return count
    }
}