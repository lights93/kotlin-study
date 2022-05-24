package pro32

// https://leetcode.com/problems/longest-valid-parentheses/
class Solution {
    private var max = 0
    fun longestValidParentheses(s: String): Int {
        var idx = 0
        var len = 0
        while (idx < s.length) {
            val c = s[idx]
            if(c == '(') {
                val end = dfs(s, idx)
                if(end == -1) {
                    max = maxOf(max, len)
                    idx++
                    len = 0
                } else {
                    len = len + end - idx + 1
                    idx = end + 1
                }
            } else {
                max = maxOf(max, len)
                len = 0
                idx++
            }
        }

        return maxOf(max, len)
    }

    private fun dfs(s: String, start: Int): Int {
        if(start > s.length) {
            return -1
        }

        var i = start + 1
        while (i < s.length) {
            val c = s[i]
            if(c == '(') {
                val end = dfs(s, i)
                if(end == -1) {
                    break
                }
                i = end + 1
            } else {
                max = maxOf(i - start + 1, max)
                return i
            }
        }

        return -1
    }
}