package pro70

// https://leetcode.com/problems/climbing-stairs/
class Solution {
    fun climbStairs(n: Int): Int {
        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = 1

        for (idx in 2 .. n) {
            dp[idx] = dp[idx - 2] + dp[idx - 1]
        }

        return dp[n]
    }
}