package pro474

// https://leetcode.com/problems/ones-and-zeroes/
class Solution {
    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        val dp = Array(101) { IntArray(101) }

        strs.forEach { str ->
            val zeros = str.count { it == '0' }
            val ones = str.count() - zeros

            for (i in m downTo zeros) {
                for( j in n downTo ones) {
                    dp[i][j] = maxOf(dp[i][j], 1 + dp[i - zeros][j - ones])
                }
            }
        }

        return dp[m][n]
    }

}