package study.algorithm.PROGRAMMERS

class SerialParticalSumKt {

    fun solution(element: IntArray):Int {
        val size = element.size
        val set: MutableSet<Int> = mutableSetOf()
        for (i in 0..size){
            updateParticalSum(set, element, i);
        }
        return set.size
    }

    private fun updateParticalSum(set: MutableSet<Int>, element: IntArray, particalCount: Int) {
        var sum: Int = 0
        for (index in 0..particalCount-1) {
            sum += element[index]
        }
        set.add(sum)
        var startIndex: Int = 0
        var endIndex: Int = particalCount-1;
        for (index in 1..element.size-1) {
            startIndex = (startIndex+1) % particalCount
            endIndex = (endIndex+1) % particalCount
            sum -= element[startIndex]
            sum += element[endIndex]
            set.add(sum)
        }
    }
}