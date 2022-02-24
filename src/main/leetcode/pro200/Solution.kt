package pro200

// https://leetcode.com/problems/number-of-islands/
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var answer = 0;
        for (i in grid.indices) {
            for (j in 0 until grid[i].size) {
                if (grid[i][j] == '1') {
                    answer++
                    helper(grid, i, j)
                }
            }
        }

        return answer
    }

    fun helper(grid: Array<CharArray>, i: Int, j: Int) {
        grid[i][j] = '2';
        if (i > 0 && grid[i - 1][j] == '1') {
            helper(grid, i - 1, j)
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            helper(grid, i, j - 1)
        }
        if (i < grid.size - 1 && grid[i + 1][j] == '1') {
            helper(grid, i + 1, j)
        }
        if (j < grid[i].size - 1 && grid[i][j + 1] == '1') {
            helper(grid, i, j + 1)
        }

    }
}