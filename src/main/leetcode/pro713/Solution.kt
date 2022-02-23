package pro713

// https://leetcode.com/problems/subarray-product-less-than-k/
class Solution {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        var start = 0
        var end = 0
        var product = 1

        var answer = 0

        while (end < nums.size) {
            product *= nums[end]
            if (product < k) {
                answer += end - start + 1
                end++
            } else {
                if (start == end) {
                    product /= nums[end]
                    start++
                    end++
                } else {
                    product /= nums[start++]
                    product /= nums[end]
                }
            }
        }

        return answer
    }
}