package pro572

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

// https://leetcode.com/problems/subtree-of-another-tree/
class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) {
            return true
        }
        if (root == null || subRoot == null) {
            return false
        }

        if (root.`val` == subRoot.`val` &&
            isSubtreeStarted(root.left, subRoot.left) && isSubtree(root.right, subRoot.right)
        ) {
            return true
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    fun isSubtreeStarted(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) {
            return true
        }
        if (root == null || subRoot == null) {
            return false
        }

        return root.`val` == subRoot.`val` &&
                isSubtreeStarted(root.left, subRoot.left) && isSubtreeStarted(root.right, subRoot.right)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}