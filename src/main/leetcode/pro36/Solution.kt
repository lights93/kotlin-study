package pro36

// https://leetcode.com/problems/valid-sudoku/

// https://leetcode.com/problems/valid-sudoku/discuss/1415732/Kotlin-Simple-Easy-and-Short-Solution

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rowRecord = Array(9) { mutableSetOf<Char>() }
        val columnRecord = Array(9) { mutableSetOf<Char>() }
        val subBoxRecord = Array(9) { mutableSetOf<Char>() }

        board.forEachIndexed { rowIndex, chars ->
            chars.forEachIndexed { columnIndex, c ->
                if (c in '1'..'9') {
                    val subBoxIndex = rowIndex / 3 * 3 + columnIndex / 3
                    if (!rowRecord[rowIndex].add(c)
                        || !columnRecord[columnIndex].add(c)
                        || !subBoxRecord[subBoxIndex].add(c)) {
                        return false
                    }
                }
            }
        }

        return true
    }
}