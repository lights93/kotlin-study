package pro59

// https://leetcode.com/problems/spiral-matrix-ii/
class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {
        val result = Array<IntArray>(n) {
            IntArray(n) {0}
        }
        var dir = 0
        var i = 0
        var j = 0
        var num = 2
        var remain = n - 1
        var temp = 0
        var time = -1
        result[i][j] = 1
        val max = n * n
        while (num <= max) {
            when (dir) {
                0 -> {
                    j++
                }
                1 -> {
                    i++
                }
                2 -> {
                    j--
                }
                else -> {
                    i--
                }
            }
            result[i][j] = num
            num++
            temp++
            if(temp == remain) {
                dir = (dir + 1) % 4
                time++
                if(time == 2) {
                    time = 0
                    remain--
                }
                temp = 0
            }
        }

        return result
    }
}