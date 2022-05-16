package pro1091

import java.util.*

// https://leetcode.com/problems/shortest-path-in-binary-matrix/
class Solution {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        var result = 0
        val queue: Queue<Pair<Int, Int>> = LinkedList()

        queue.add(Pair(0, 0))

        while (queue.isNotEmpty()) {
            result++
            val size = queue.size
            for (i in 0 until size) {
                val poll = queue.poll()
                if (poll.first < 0 || poll.first >= grid.size || poll.second < 0 || poll.second >= grid.size) {
                    continue
                }
                if (grid[poll.first][poll.second] == 1) {
                    continue
                }

                if (poll.first == grid.size - 1 && poll.second == grid.size - 1) {
                    return result
                }

                grid[poll.first][poll.second] = 1

                queue.add(Pair(poll.first + 1, poll.second + 1))
                queue.add(Pair(poll.first + 1, poll.second))
                queue.add(Pair(poll.first + 1, poll.second - 1))
                queue.add(Pair(poll.first, poll.second + 1))
                queue.add(Pair(poll.first, poll.second - 1))
                queue.add(Pair(poll.first - 1, poll.second + 1))
                queue.add(Pair(poll.first - 1, poll.second))
                queue.add(Pair(poll.first - 1, poll.second - 1))
            }
        }

        return -1
    }

}

//class Solution {
//    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
//        val dp = Array(grid.size) {
//            IntArray(grid.size) { Int.MAX_VALUE }
//        }
//
//        solve(grid, 0, 0, dp, 1)
//        if(dp[grid.size - 1][grid.size - 1] == Int.MAX_VALUE) {
//            return -1
//        }
//
//        return dp[grid.size - 1][grid.size - 1]
//    }
//
//    private fun solve(grid: Array<IntArray>, i: Int, j: Int, dp: Array<IntArray>, len: Int) {
//        if(i < 0 || i >= grid.size || j < 0 || j >= grid.size) {
//            return
//        }
//
//        if(grid[i][j] == 1) {
//            return
//        }
//
//        if(len >= dp[i][j] || len >= dp[grid.size - 1][grid.size - 1]) {
//            return
//        }
//
//        dp[i][j] = len
//
//        solve(grid, i + 1, j, dp, len + 1)
//        solve(grid, i, j + 1, dp, len + 1)
//        solve(grid, i + 1, j + 1, dp, len + 1)
//        solve(grid, i - 1, j, dp, len + 1)
//        solve(grid, i, j - 1, dp, len + 1)
//        solve(grid, i - 1, j - 1, dp, len + 1)
//        solve(grid, i + 1, j - 1, dp, len + 1)
//        solve(grid, i - 1, j + 1, dp, len + 1)
//    }
//
//}