package pro60063

// https://programmers.co.kr/learn/courses/30/lessons/60063
class Solution {
    private var dp: MutableMap<Pair<Pair<Int, Int>, Pair<Int, Int>>, Int> = mutableMapOf()
    fun solution(board: Array<IntArray>): Int {
        solve(board, Pair(0, 0), Pair(0, 1), 0)
        return minOf(dp.getOrDefault(Pair(Pair(board.size - 2, board.size - 1), Pair(board.size - 1, board.size - 1)), Int.MAX_VALUE),
            dp.getOrDefault(Pair(Pair(board.size - 1, board.size - 2), Pair(board.size - 1, board.size - 1)), Int.MAX_VALUE))
    }

    private fun solve(board: Array<IntArray>, pair1: Pair<Int, Int>, pair2: Pair<Int, Int>, sum: Int) {
        if (dp.getOrDefault(Pair(pair1, pair2), Int.MAX_VALUE) <= sum) {
            return
        }

        dp[Pair(pair1, pair2)] = sum

        if(pair2.first == board.size -1 && pair2.second == board.size - 1) {
            return
        }
        if (pair1.first == pair2.first) { // 가로
            // 아래로 내림
            if (pair2.first + 1 < board.size && board[pair1.first + 1][pair1.second] == 0 && board[pair2.first + 1][pair2.second] == 0) {
                solve(board, Pair(pair1.first + 1, pair1.second), Pair(pair2.first + 1, pair2.second), sum + 1)
                solve(board, pair2, Pair(pair2.first + 1, pair2.second), sum + 1)
                solve(board, pair1, Pair(pair1.first + 1, pair1.second), sum + 1)
            }

            // 위로 올림
            if (pair1.first > 0 && board[pair1.first - 1][pair1.second] == 0 && board[pair2.first - 1][pair2.second] == 0) {
                solve(board, Pair(pair1.first - 1, pair1.second), Pair(pair2.first - 1, pair2.second), sum + 1)
                solve(board, Pair(pair2.first - 1, pair2.second), pair2, sum + 1)
                solve(board, Pair(pair1.first - 1, pair1.second), pair1, sum + 1)
            }

            // 오른쪽 이동
            if (pair2.second + 1 < board.size && board[pair2.first][pair2.second + 1] == 0) {
                solve(board, pair2, Pair(pair2.first, pair2.second + 1), sum + 1)
            }

            // 왼쪽 이동
            if (pair1.second > 0 && board[pair1.first][pair1.second - 1] == 0) {
                solve(board, Pair(pair1.first, pair1.second - 1), pair1, sum + 1)
            }
        } else { // 세로
            // 아래로 내림
            if (pair2.first + 1 < board.size && board[pair2.first + 1][pair2.second] == 0) {
                solve(board, pair2, Pair(pair2.first + 1, pair2.second), sum + 1)
            }

            // 위로 올림
            if (pair1.first > 0 && board[pair1.first - 1][pair1.second] == 0) {
                solve(board, Pair(pair1.first - 1, pair1.second), pair1, sum + 1)
            }

            // 오른쪽 이동
            if (pair2.second + 1 < board.size && board[pair2.first][pair2.second + 1] == 0 && board[pair1.first][pair1.second + 1] == 0) {
                solve(board, Pair(pair1.first, pair1.second + 1), Pair(pair2.first, pair2.second + 1), sum + 1)
                solve(board, pair1, Pair(pair1.first, pair1.second + 1), sum + 1)
                solve(board, pair2, Pair(pair2.first, pair2.second + 1), sum + 1)
            }

            // 왼쪽 이동
            if(pair1.second > 0 && board[pair2.first][pair2.second - 1] == 0 && board[pair1.first][pair1.second - 1] == 0) {
                solve(board, Pair(pair1.first, pair1.second - 1), Pair(pair2.first, pair2.second - 1), sum + 1)
                solve(board, Pair(pair1.first, pair1.second - 1), pair1, sum + 1)
                solve(board, Pair(pair2.first, pair2.second - 1), pair2, sum + 1)
            }
        }
    }
}