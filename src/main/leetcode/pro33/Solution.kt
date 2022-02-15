package pro33

// https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left < right) {
            val mid = left + (right - left) / 2

            if (nums[mid] == target) {
                return mid
            }

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

        val minIdx = left

        left = minIdx
        right = minIdx + nums.size

        while (left < right) {
            val mid = left + (right - left) / 2
            val idx = mid % nums.size

            if (nums[idx] == target) {
                return idx
            }

            if (nums[idx] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        if (nums[left % nums.size] == target) {
            return left % nums.size
        }

        return -1
    }
}