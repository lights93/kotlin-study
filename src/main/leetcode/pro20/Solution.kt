package pro20

import java.util.*

// https://leetcode.com/problems/valid-parentheses/
class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        for (bracket in s) {
            when (bracket) {
                '(', '{', '[' -> stack.push(bracket)
                ')' -> {
                    if (stack.empty() || stack.pop() != '(') {
                        return false
                    }
                }
                '}' -> {
                    if (stack.empty() || stack.pop() != '{') {
                        return false
                    }
                }
                ']' -> {
                    if (stack.empty() || stack.pop() != '[') {
                        return false
                    }
                }
            }
        }

        return stack.empty()
    }
}