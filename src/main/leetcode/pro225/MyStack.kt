package pro225

import java.util.LinkedList
import java.util.Queue

class MyStack() {
    var queue : Queue<Int> = LinkedList()
    fun push(x: Int) {
        var newQueue : Queue<Int> = LinkedList()
        newQueue.add(x)
        while (queue.isNotEmpty()) {
            newQueue.add(queue.poll())
        }

        queue = newQueue
    }

    fun pop(): Int {
        return queue.poll()
    }

    fun top(): Int {
        return queue.peek()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */