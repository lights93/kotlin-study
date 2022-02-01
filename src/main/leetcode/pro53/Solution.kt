package pro53

// https://leetcode.com/problems/maximum-subarray/
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var sum = 0
        var max = nums[0]
        nums.forEach { num ->
            sum = (sum + num).coerceAtLeast(num)
            max = max.coerceAtLeast(sum)
        }

        return max
    }
}