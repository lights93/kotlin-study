package pro289

// https://leetcode.com/problems/game-of-life/
class Solution {
    fun gameOfLife(board: Array<IntArray>): Unit {
        for ((i, arr) in board.withIndex()) {
            for ((j, num) in arr.withIndex()) {
                if (isNextAlive(board, i, j)) {
                    if (num == 0) {
                        board[i][j] = -2
                    }
                } else {
                    if (num == 1) {
                        board[i][j] = -1
                    }
                }
            }
        }

        for ((i, arr) in board.withIndex()) {
            for ((j, _) in arr.withIndex()) {
                if (board[i][j] == -2) {
                    board[i][j] = 1
                } else if (board[i][j] == -1) {
                    board[i][j] = 0
                }
            }
        }
    }

    private fun isNextAlive(board: Array<IntArray>, i: Int, j: Int): Boolean {
        val count = countNeighbors(board, i, j)

        if (board[i][j] == 1 || board[i][j] == -1) {
            return count == 2 || count == 3
        }

        return count == 3
    }

    private fun countNeighbors(board: Array<IntArray>, i: Int, j: Int): Int {
        var count = 0

        count += getCount(board, i - 1, j - 1)
        count += getCount(board, i - 1, j)
        count += getCount(board, i - 1, j + 1)
        count += getCount(board, i, j - 1)
        count += getCount(board, i, j + 1)
        count += getCount(board, i + 1, j - 1)
        count += getCount(board, i + 1, j)
        count += getCount(board, i + 1, j + 1)

        return count
    }

    private fun getCount(board: Array<IntArray>, i: Int, j: Int): Int {
        if (i < 0 || i >= board.size || j < 0 || j >= board[0].size) {
            return 0
        }
        if (board[i][j] == -1 || board[i][j] == 1) {
            return 1
        }
        return 0
    }

}