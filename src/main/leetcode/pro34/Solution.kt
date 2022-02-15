package pro34

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val result = intArrayOf(-1, -1)

        if (nums.isEmpty()) {
            return result
        }
        var left = 0
        var right = nums.size

        if (nums[0] == target) {
            result[0] = 0
        } else {
            while (left < right) {
                val findValue = nums.binarySearch(target, left, right)
                if (findValue < 0) {
                    break
                }

                result[0] = findValue
                right = findValue
            }
        }

        if (nums[nums.size - 1] == target) {
            result[1] = nums.size - 1
        } else {
            right = nums.size
            while (left < right) {
                val findValue = nums.binarySearch(target, left, right)
                if (findValue < 0) {
                    break
                }

                result[1] = findValue
                left = findValue + 1
            }
        }

        return result
    }
}