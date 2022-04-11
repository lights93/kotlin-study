package pro1260

// https://leetcode.com/problems/shift-2d-grid/
class Solution {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val rowSize = grid.size
        val columnSize = grid[0].size
        val size = rowSize * columnSize

        println(rowSize)
        println(columnSize)


        val answer = MutableList(rowSize) {
            MutableList(columnSize) { 0 }
        }

        for (num in 0 until size) {
            val originRow = num / columnSize
            val originCol = num - originRow * columnSize
            val moved = (num + k) % size
            val newRow = moved / columnSize
            val newCol = moved - newRow * columnSize
            answer[newRow][newCol] = grid[originRow][originCol]
        }

        return answer
    }
}