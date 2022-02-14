package pro653

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

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
class Solution {
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        if (root == null) {
            return false
        }

        val set = mutableSetOf<Int>()
        val queue: Queue<TreeNode> = LinkedList()

        queue.add(root)

        while (queue.isNotEmpty()) {
            val node = queue.poll()

            if (set.contains(k - node.`val`)) {
                return true
            }

            set.add(node.`val`)

            if (node.left != null) {
                queue.add(node.left)
            }

            if (node.right != null) {
                queue.add(node.right)
            }
        }

        return false
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}