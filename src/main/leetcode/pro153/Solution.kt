package pro153

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1

        while (left < right) {
            val mid = left + (right - left) / 2

            if (nums[left] >= nums[mid] && nums[mid] < nums[right]) {
                left += 1
                right = mid
                continue
            }

            if (nums[left] <= nums[mid] && nums[mid] < nums[right]) {
                right = left
                continue
            }

            if (nums[left] <= nums[mid] && nums[mid] > nums[right]) {
                left = mid + 1
                continue
            }
        }

        return nums[right]
    }
}