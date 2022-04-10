package pro682

import java.util.*

class Solution {
    fun calPoints(ops: Array<String>): Int {
        val stack : Deque<Int> = LinkedList()
        for (op in ops) {
            when (op) {
                "+" -> {
                    val pop = stack.pop()
                    val sum = pop + stack.peek()
                    stack.push(pop)
                    stack.push(sum)
                }
                "C" -> {
                    stack.pop()
                }
                "D" -> {
                    stack.push(2 * stack.peek())
                }
                else -> {
                    stack.push(Integer.parseInt(op))
                }
            }
        }

        return stack.sum()
    }
}