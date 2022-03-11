package pro198

// https://leetcode.com/problems/house-robber/
class Solution {
    fun rob(nums: IntArray): Int = when (nums.size) {
        1 -> nums[0]
        2 -> maxOf(nums[0], nums[1])
        else -> {
            val dp = IntArray(nums.size)

            dp[0] = nums[0]
            dp[1] = maxOf(nums[0], nums[1])

            for (idx in 2 until nums.size) {
                dp[idx] = maxOf(dp[idx - 2] + nums[idx], dp[idx - 1])
            }

            maxOf(dp.last(), dp[dp.lastIndex - 1])
        }
    }
}