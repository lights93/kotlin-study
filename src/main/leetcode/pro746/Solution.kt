package pro746

// https://leetcode.com/problems/min-cost-climbing-stairs/
class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val dp = IntArray(cost.size + 1)
        dp[0] = 0
        dp[1] = 0

        for (idx in 2 .. cost.size) {
            dp[idx] = minOf(dp[idx -2] + cost[idx - 2], dp[idx - 1] + cost[idx - 1])
        }

        return dp.last()
    }
}