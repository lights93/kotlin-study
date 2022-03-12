package pro213

class Solution {
    fun rob(nums: IntArray): Int = when (nums.size) {
        1 -> nums[0]
        2 -> maxOf(nums[0], nums[1])
        else -> {
            val dp = IntArray(nums.size)

            dp[0] = 0
            dp[1] =  nums[1]
            dp[2] =  maxOf(nums[1], nums[2])

            for (idx in 3 until nums.size) {
                dp[idx] = maxOf(dp[idx - 2] + nums[idx], dp[idx - 1])
            }

            val answer1 = dp.last()

            dp[0] = nums[0]
            dp[1] = nums[0]

            for (idx in 2 until nums.size - 1) {
                dp[idx] = maxOf(dp[idx - 2] + nums[idx], dp[idx - 1])
            }

            val answer2 = dp[dp.lastIndex - 1]

            maxOf(answer1 ,answer2)
        }
    }
}