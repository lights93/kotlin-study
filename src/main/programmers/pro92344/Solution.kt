package pro92344

// https://programmers.co.kr/learn/courses/30/lessons/92344
// https://tech.kakao.com/2022/01/14/2022-kakao-recruitment-round-1/
class Solution {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        for (ints in skill) {
            val type = ints[0]
            val rowRange = ints[1] .. ints[3]
            val colRange = ints[2] .. ints[4]
            val degree = ints[5]
            for (i in rowRange) {
                for (j in colRange) {
                    if(type == 1) {
                        board[i][j] -= degree
                    } else {
                        board[i][j] += degree
                    }
                }
            }
        }

        return board.flatMap { it.toList() }
            .count { it > 0 }
    }
}