package study.algorithm.PROGRAMMERS.basic

class ParticleSumK {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = IntArray(2)
        var gap = Int.MAX_VALUE
        var left = 0
        var right = 0
        var sum = 0
        while(sum < k) {
            sum += sequence[right++]
        }
        for(i in right..sequence.size) {
            while(sum > k) {
                sum -= sequence[left++]
            }
            if(sum == k) {
                var curGap = i-left
                if(curGap < gap) {
                    gap = curGap
                    answer[0] = left
                    answer[1] = i-1
                }
            }
            if(i < sequence.size) {
                sum += sequence[i]
            }
        }
        return answer
    }
}