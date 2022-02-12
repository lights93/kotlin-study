package pro101

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

// https://leetcode.com/problems/symmetric-tree/
class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        val queue: Queue<TreeNode> = LinkedList()

        queue.add(root.left)
        queue.add(root.right)

        while (queue.isNotEmpty()) {
            val size = queue.size

            val leftList = mutableListOf<Int?>()
            repeat(size / 2) {
                val node = queue.poll()
                if (node != null) {
                    queue.add(node.left)
                    queue.add(node.right)
                    leftList.add(node.`val`)
                } else {
                    leftList.add(null)
                }
            }

            (0 until size / 2).forEach {
                val node = queue.poll()
                if (node != null) {
                    if (node.`val` != leftList[size / 2 - 1 - it]) {
                        return false
                    }
                    queue.add(node.left)
                    queue.add(node.right)
                } else {
                    if (leftList[size / 2 - 1 - it] != null) {
                        return false
                    }
                }
            }
        }

        return true

    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
