package pro456

import java.util.*

// https://leetcode.com/problems/132-pattern/
class Solution {
    fun find132pattern(nums: IntArray): Boolean {
        val stack = Stack<Int>()
        var second = Int.MIN_VALUE

        for (i in nums.size - 1 downTo 0) {
            val num = nums[i]
            if(num < second) {
                return true
            }

            while (stack.isNotEmpty() && num > stack.peek()) {
                second = stack.pop()
            }

            stack.push(num)
        }

        return false
    }
}