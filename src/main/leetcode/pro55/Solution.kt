package pro55

// https://leetcode.com/problems/jump-game/
class Solution {

    fun canJump(nums: IntArray): Boolean {
        val notAnswer = BooleanArray(nums.size)
        return helper(notAnswer,nums, 0)
    }

    private fun helper(notAnswer: BooleanArray, nums: IntArray, current: Int): Boolean {
        if(current >= nums.size - 1) {
            return true
        }
        if(notAnswer[current]) {
            return false
        }

        for(i in 1 .. nums[current]) {
            if(helper(notAnswer, nums, current + i)) {
                return true
            }
        }

        notAnswer[current] = true
        return false
    }
}