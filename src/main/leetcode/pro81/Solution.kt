package pro81

// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
class Solution {
    fun search(nums: IntArray, target: Int): Boolean {
        val list = nums.toMutableList()
            .distinct()
            .sorted()
        var left = 0
        var right = list.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            println("$left $right $mid")
            if (list[mid] == target) {
                return true
            }

            if(list[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }

        }

        return false
    }
}