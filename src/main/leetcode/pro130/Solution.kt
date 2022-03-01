package pro130

class Solution {
    fun solve(board: Array<CharArray>): Unit {

        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] == 'O') {
                    val used = HashSet<Pair<Int, Int>>()
                    if (isSurrounded(board, i, j, used)) {
                        for ((r, c) in used) {
                            board[r][c] = 'X'
                        }
                    }
                }
            }
        }
    }

    private fun isSurrounded(board: Array<CharArray>, i: Int, j: Int, used: MutableSet<Pair<Int, Int>>): Boolean {
        if (i <= 0) {
            return false
        }
        if (j <= 0) {
            return false
        }
        if (i >= board.size - 1) {
            return false
        }
        if (j >= board[0].size - 1) {
            return false
        }
        used.add(i to j)

        if (board[i - 1][j] == 'O' && !used.contains(i - 1 to j) && !isSurrounded(board, i - 1, j, used)) {
            return false
        }


        if (board[i][j - 1] != 'X' && !used.contains(i to j - 1) && !isSurrounded(board, i, j - 1, used)) {
            return false
        }


        if (board[i + 1][j] != 'X' && !used.contains(i + 1 to j) && !isSurrounded(board, i + 1, j, used)) {
            return false
        }


        if (board[i][j + 1] != 'X' && !used.contains(i to j + 1) && !isSurrounded(board, i, j + 1, used)) {
            return false
        }

        return true
    }
}