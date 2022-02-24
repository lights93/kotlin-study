package pro547

// https://leetcode.com/problems/number-of-provinces/
class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        var answer = 0;
        for (i in isConnected.indices) {
            if (dfs(isConnected, i)) {
                answer++
            }
        }
        return answer
    }

    private fun dfs(isConnected: Array<IntArray>, idx: Int): Boolean {
        var find = false
        for (j in isConnected[idx].indices) {
            if (isConnected[idx][j] == 1) {
                find = true
                isConnected[idx][j] = 0
                if (j != idx) {
                    dfs(isConnected, j)
                }
            }
        }

        return find
    }
}