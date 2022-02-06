package pro74

// https://leetcode.com/problems/search-a-2d-matrix/
class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix[0].size

        var mid: Int
        var left = 0
        var right = m * n - 1

        if(target < matrix[0][0] || target > matrix[m- 1][n - 1]) {
            return false
        }

        while (left <= right) {
            mid = (left + right) / 2
            val num = matrix[mid / n][mid % n]

            when {
                num == target -> return true
                num > target -> right = mid - 1
                else -> left = mid + 1
            }
        }

        return false
    }
}