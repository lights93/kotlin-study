package pro235

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? = when {
        p!!.`val` < root!!.`val` && q!!.`val` < root.`val` -> {
            lowestCommonAncestor(root.left, p, q)
        }
        p.`val` > root.`val` && q!!.`val` > root.`val` -> {
            lowestCommonAncestor(root.right, p, q)
        }
        else -> root
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}