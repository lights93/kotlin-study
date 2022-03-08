package pro509

// https://leetcode.com/problems/fibonacci-number/
class Solution {
    fun fib(n: Int): Int {
        if (n <= 1) {
            return n
        }
        val dp = IntArray(n + 1)
        dp[0] = 0
        dp[1] = 1

        for (idx in 2..n) {
            dp[idx] = dp[idx - 1] + dp[idx - 2]
        }

        return dp[n]
    }
}