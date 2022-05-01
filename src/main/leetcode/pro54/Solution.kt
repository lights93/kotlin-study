package pro54

// https://leetcode.com/problems/spiral-matrix/
class Solution {
    companion object {
        val direction = arrayOf(
            Pair(0,1),
            Pair(1,0),
            Pair(0,-1),
            Pair(-1,0)
        )
    }
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val ends = intArrayOf(matrix[0].size - 1, matrix.size - 1, 0, 0)
        var directionIdx = 0

        val answer = mutableListOf<Int>()

        var i = 0
        var j = 0
        while (answer.size < matrix.size * matrix[0].size) {
            if(j > ends[0] || j < ends[2] || i > ends[1] || i < ends[3]) {
                i -= direction[directionIdx].first
                j -= direction[directionIdx].second
                val before = (directionIdx + 3) % 4
                if(before == 0 || before == 1) {
                    ends[before]--
                } else {
                    ends[before]++
                }
                directionIdx = (directionIdx + 1) % 4
                i += direction[directionIdx].first
                j += direction[directionIdx].second
                continue
            }
            answer.add(matrix[i][j])
            i += direction[directionIdx].first
            j += direction[directionIdx].second
        }

        return answer
    }
}