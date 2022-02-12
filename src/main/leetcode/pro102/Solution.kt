package pro102

import java.util.*

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

// https://leetcode.com/problems/binary-tree-level-order-traversal/
class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = arrayListOf<List<Int>>()

        val queue: Queue<TreeNode> = LinkedList()

        queue.add(root)

        while (queue.isNotEmpty()) {
            val size = queue.size

            val tempList = mutableListOf<Int>()

            repeat(size) {
                val tempNode = queue.poll()
                if (tempNode != null) {
                    queue.add(tempNode.left)
                    queue.add(tempNode.right)
                    tempList.add(tempNode.`val`)
                }
            }

            if (tempList.isNotEmpty()) {
                result.add(tempList)
            }
        }

        return result
    }
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
