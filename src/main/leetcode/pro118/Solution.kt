package pro118

// https://leetcode.com/problems/pascals-triangle/
class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        (0 until numRows).forEach { num1 ->
            val list = mutableListOf<Int>()
            (0 until num1 + 1).forEach { num2 ->
                if (num2 == 0 || num2 == num1) {
                    list.add(1)
                } else {
                    list.add(result[num1 - 1][num2 - 1] + result[num1 - 1][num2])
                }
            }
            result.add(list)
        }

        return result
    }
}