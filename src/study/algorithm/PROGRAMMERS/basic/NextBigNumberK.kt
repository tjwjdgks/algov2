package study.algorithm.PROGRAMMERS.basic

import java.util.*

class NextBigNumberK {
    fun solution(numbers: IntArray): IntArray {
        val answer = IntArray(numbers.size)
        val deque: Deque<Int> = LinkedList()
        for (i in numbers.lastIndex downTo 0) {
            while(!deque.isEmpty()){
                val backwardNum = deque.pollFirst()
                if(numbers[i] < backwardNum) {
                    deque.addFirst(backwardNum)
                    deque.addFirst(numbers[i])
                    answer[i] = backwardNum
                    break
                }
            }
            if (deque.isEmpty()){
                answer[i] = -1;
                deque.addFirst(numbers[i])
            }

        }
        return answer
    }
}