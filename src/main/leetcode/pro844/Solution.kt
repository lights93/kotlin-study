package pro844

import java.util.*

// https://leetcode.com/problems/backspace-string-compare/
class Solution {
    fun backspaceCompare(s: String, t: String): Boolean {
        val result1 = calculateResult(s)
        val result2 = calculateResult(t)

        return result1 == result2
    }

    private fun calculateResult(text: String): String {
        val stack = Stack<Char>()

        for (c in text) {
            if (c == '#') {
                if (stack.isNotEmpty()) {
                    stack.pop()
                }
            } else {
                stack.push(c)
            }
        }

        return stack.joinToString { it.toString() }
    }
}