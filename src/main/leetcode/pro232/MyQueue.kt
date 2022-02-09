package pro232

import java.util.*

// https://leetcode.com/problems/implement-queue-using-stacks
// 참고: https://leetcode.com/problems/implement-queue-using-stacks/discuss/64206/Short-O(1)-amortized-C%2B%2B-Java-Ruby
class MyQueue() {
    private val input = Stack<Int>()
    private val output = Stack<Int>()

    fun push(x: Int) {
        input.push(x)
    }

    fun pop(): Int {
        makeOutputIfEmpty()
        return output.pop()
    }

    fun peek(): Int {
        makeOutputIfEmpty()
        return output.peek()
    }

    private fun makeOutputIfEmpty() {
        if (output.empty()) {
            inputToOutput()
        }
    }

    private fun inputToOutput() {
        while (input.isNotEmpty()) {
            output.push(input.pop())
        }
    }

    fun empty() = input.empty() && output.empty()

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */