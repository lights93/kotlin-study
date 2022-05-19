package pro329

// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
class Solution {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val dp = Array<IntArray>(matrix.size) {
            IntArray(matrix[0].size) { 0 }
        }

        var answer = 0
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                answer = maxOf(answer, solve(matrix, dp, i, j, 0, -1))
            }
        }

        return answer
    }

    private fun solve(matrix: Array<IntArray>, dp: Array<IntArray>, i: Int, j: Int, len: Int, prev: Int): Int {
        if (i < 0 || j < 0 || i >= dp.size || j >= dp[0].size) {
            return 0
        }
        if (len < dp[i][j]) {
            return 0
        }

        if (matrix[i][j] <= prev) {
            return 0
        }

        dp[i][j] = len + 1

        var max = len + 1
        max = maxOf(solve(matrix, dp, i + 1, j, len + 1, matrix[i][j]), max)
        max = maxOf(solve(matrix, dp, i - 1, j, len + 1, matrix[i][j]), max)
        max = maxOf(solve(matrix, dp, i, j + 1, len + 1, matrix[i][j]), max)
        max = maxOf(solve(matrix, dp, i, j - 1, len + 1, matrix[i][j]), max)

        return max
    }
}