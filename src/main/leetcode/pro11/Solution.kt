package pro11

// https://leetcode.com/problems/container-with-most-water/
class Solution {
    fun maxArea(height: IntArray): Int {
        var max = 0
        for (i in 0 until height.size - 1) {
            if (height[i] * (height.size - i - 1) <= max) {
                continue
            }

            for (j in i + 1 until height.size) {
                max = maxOf(max, (j - i) * minOf(height[i], height[j]))
            }
        }

        return max
    }
}