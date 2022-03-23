package pro1567

// https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
class Solution {
    fun getMaxLen(nums: IntArray): Int {
        var answer = 0
        var isLeftPositive: Boolean? = null
        var isRightPositive: Boolean? = null
        var left = 0
        var right = 0

        for (i in nums.indices) {
            left++
            right++
            if (nums[i] == 0) {
                isLeftPositive = null
                left = 0
            }
            else if (nums[i] < 0) {
                isLeftPositive = if (isLeftPositive == null) {
                    false
                } else {
                    !isLeftPositive
                }
            }
            else {
                if (isLeftPositive == null) {
                    isLeftPositive = true
                }
            }

            if (isLeftPositive != null && isLeftPositive) {
                answer = maxOf(answer, left)
            }

            if (nums[nums.size - 1 - i] == 0) {
                isRightPositive = null
                right = 0
            } else if (nums[nums.size - 1 - i] < 0) {
                isRightPositive = if (isRightPositive == null) {
                    false
                } else {
                    !isRightPositive
                }
            } else {
                if (isRightPositive == null) {
                    isRightPositive = true
                }
            }

            if (isRightPositive != null && isRightPositive) {
                answer = maxOf(answer, right)
            }
        }

        return answer
    }
}