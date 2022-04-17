package pro897

import java.util.Deque
import java.util.LinkedList

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

// https://leetcode.com/problems/increasing-order-search-tree/
class Solution {
    fun increasingBST(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        val stack : Deque<TreeNode> = LinkedList<TreeNode>()

        var leaf : TreeNode? = null
        var answer : TreeNode? = null

        stack.push(root)
        while (stack.isNotEmpty()) {
            val node = stack.peek()
            println(node.`val`)

            if(node.left != null) {
                stack.push(node.left)
                node.left = null
                continue
            }
            stack.pop()
            if(node.right != null) {
                stack.push(node.right)
            }

            if(leaf == null) {
                leaf = node
                answer = node
            } else {
                leaf.right = node
                leaf = leaf.right
            }
        }

        return answer
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}