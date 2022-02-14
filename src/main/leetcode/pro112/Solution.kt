package pro112

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

// https://leetcode.com/problems/path-sum/
class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) {
            return false
        }

        val stack = Stack<TreeNode>()
        stack.push(root)

        while (stack.isNotEmpty()) {
            val node = stack.pop()
            if (node.left == null && node.right == null) {
                if (node.`val` == targetSum) {
                    return true
                }
                continue
            }

            if (node.left != null) {
                node.left!!.`val` += node.`val`
                stack.push(node.left)
            }

            if (node.right != null) {
                node.right!!.`val` += node.`val`
                stack.push(node.right)
            }
        }

        return false
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
