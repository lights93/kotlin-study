package pro145

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

// https://leetcode.com/problems/binary-tree-postorder-traversal/
class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()

        if (root == null) {
            return list
        }

        list.addAll(postorderTraversal(root.left))
        list.addAll(postorderTraversal(root.right))
        list.add(root.`val`)

        return list
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}