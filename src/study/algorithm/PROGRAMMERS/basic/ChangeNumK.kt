package study.algorithm.PROGRAMMERS.basic

import java.util.*
import kotlin.math.min

class ChangeNumK {
    fun solution(x: Int, y: Int, n: Int): Int {
        var dp = IntArray(y+1){Int.MAX_VALUE/2}
        dp[x] = 0
        for(k: Int in x..y){
            if(k%2 == 0) {
                dp[k] = min(dp[k], dp[k/2]+1)
            }
            if(k%3 == 0) {
                dp[k] = min(dp[k], dp[k/3]+1)
            }
            if(k-n >= 0) {
                dp[k] = min(dp[k], dp[k-n]+1)
            }
        }
        return if(dp[y] == Int.MAX_VALUE/2) -1 else dp[y];
    }
}