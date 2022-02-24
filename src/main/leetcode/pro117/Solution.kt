package pro117

import java.util.*

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
class Solution {
    fun connect(root: Node?): Node? {
        if (root == null) {
            return null
        }
        val queue: Queue<Node> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val size = queue.size
            var before = queue.poll()
            if (before.left != null) {
                queue.add(before.left)
            }

            if (before.right != null) {
                queue.add(before.right)
            }
            for (i in 1 until size) {
                val node = queue.poll()
                before.next = node
                before = node

                if (node.left != null) {
                    queue.add(node.left)
                }

                if (node.right != null) {
                    queue.add(node.right)
                }
            }
        }

        return root

    }
}

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}