package pro1302

import java.util.*


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun deepestLeavesSum(root: TreeNode?): Int {
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()

        var answer = 0
        queue.add(root)
        while (queue.isNotEmpty()) {
            answer = 0
            val size = queue.size
            repeat(size) {
                val node = queue.poll()
                if (node.left != null) {
                    queue.add(node.left)
                }
                if (node.right != null) {
                    queue.add(node.right)
                }

                answer += node.`val`
            }
        }

        return answer
    }
}