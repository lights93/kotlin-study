package pro1137

// https://leetcode.com/problems/n-th-tribonacci-number/
class Solution {
    fun tribonacci(n: Int): Int {
        if(n == 0) {
            return 0
        }
        if(n < 3) {
            return 1
        }

        val dp = IntArray(n + 1)
        dp[0] = 0
        dp[1] = 1
        dp[2] = 1

        (3 .. n).forEach {
            dp[it] = dp[it -1] + dp[it - 2] + dp[it - 3]
        }

        return dp[n]
    }
}