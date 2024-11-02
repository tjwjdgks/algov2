package study.algorithm.PROGRAMMERS.basic

class EasyAlgorithmTest {

    fun solution1(numbers: IntArray, n: Int): Int {
        var total = 0
        for(number in numbers){
            total += number
            if(total > n) return total
        }
        return -1
    }

    // filterIndexed는 List 반환 Array 변환시 toTypedArray 사용
    fun solution2(todo_list: Array<String>, finished: BooleanArray): Array<String> {
        return todo_list.filterIndexed{i, todo -> !finished[i]}.toTypedArray()
    }

    fun solution3(num_list: IntArray, n: Int): IntArray {
        val array = IntArray(num_list.size)
        var start = n
        var index = 0
        while(index < num_list.size){
            start = start % num_list.size
            array[index++] = num_list[start++]
        }
        return array
    }

    fun solution3_fancy(numList: IntArray, n: Int) = (numList + numList).copyOfRange(n, n + numList.size)

    fun solution4(arr: IntArray, idx: Int): Int {
        for(index in arr.indices) {
            if(index >= idx &&  arr[index] == 1) return index
        }
        return -1
    }
    fun solution4_fancy(arr: IntArray, idx: Int): Int = (idx until arr.size).firstOrNull { arr[it] == 1 } ?: -1
    fun solution5(my_string: String): Array<String> {
        var answer = mutableListOf<String>()
        (0 until my_string.length).forEach { i -> answer.add(my_string.substring(i, my_string.length)) }
        return answer.sorted().toTypedArray()
    }




}