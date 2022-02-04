package pro566

// https://leetcode.com/problems/reshape-the-matrix/
class Solution {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val result = Array(r) { IntArray(c) }

        if (mat.size * mat[0].size != r * c) {
            return mat
        }

        var idx = 0
        mat.forEach { ints ->
            ints.forEach {
                val row = idx / c
                val column = idx % c
                result[row][column] = it
                idx++
            }
        }

        return result
    }

}