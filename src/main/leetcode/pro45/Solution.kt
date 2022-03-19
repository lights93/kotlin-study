package pro45

// https://leetcode.com/problems/jump-game-ii/
class Solution {
    fun jump(nums: IntArray): Int {
        val steps = IntArray(nums.size)
        steps.fill(Int.MAX_VALUE)

        steps[0] = 0

        for(i in nums.indices) {
            if(steps[i] == Int.MAX_VALUE) {
                continue
            }
            for (j in 1 .. nums[i]) {
                if(i + j >= nums.size) {
                    break
                }
                steps[i + j] = minOf(steps[i + j], steps[i] + 1)
            }
        }

        return steps.last()
    }
}