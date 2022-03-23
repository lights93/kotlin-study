package pro152

// https://leetcode.com/problems/maximum-product-subarray/
class Solution {
    fun maxProduct(nums: IntArray): Int {
        var left = 0
        var right = 0

        var max = nums[0]

        for (i in nums.indices) {
            left = (if(left == 0) 1 else left) *  nums[i]
            right = (if(right == 0) 1 else right) *  nums[nums.size - i - 1]
            max = maxOf(max, left, right)
        }

        return max
    }
}