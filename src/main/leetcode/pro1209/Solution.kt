package pro1209

import java.util.*

class Solution {
    fun removeDuplicates(s: String, k: Int): String {
        val stack : Stack<Pair<Char, Int>> = Stack()

        for (c in s) {
            if(stack.isEmpty()) {
                stack.push(Pair(c, 1))
                continue
            }

            val top =stack.peek()
            if(top.first == c) {
                val pop = stack.pop()
                if (pop.second + 1 != k) {
                    stack.push(Pair(c, pop.second + 1))
                }
            } else {
                stack.push(Pair(c, 1))
            }
        }

        val answer = StringBuilder()
        while (stack.isNotEmpty()) {
            val pop = stack.pop()
            answer.append(pop.first.toString().repeat(pop.second))
        }

        return answer.toString().reversed()
    }
}