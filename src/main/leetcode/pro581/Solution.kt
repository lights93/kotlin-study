package pro581

class Solution {
    fun findUnsortedSubarray(nums: IntArray): Int {
        var maxIdx = 0

        var end = -1
        for (i in 1 until nums.size) {
            if (nums[i] < nums[maxIdx]) {
                end = i
            } else {
                maxIdx = i
            }
        }

        if (end == -1) {
            return 0
        }

        var start = -1
        var minIdx = nums.size - 1
        for (i in nums.size - 2 downTo 0) {
            if (nums[i] > nums[minIdx]) {
                start = i
            } else {
                minIdx = i
            }
        }

        return end - start + 1
    }
}