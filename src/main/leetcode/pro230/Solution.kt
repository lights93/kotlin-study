package pro230

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

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if(root == null) {
            return -1
        }

        val leftLen = len(root.left)
        if(leftLen > k) {
            return kthSmallest(root.left, k)
        }
        if(leftLen == k - 1) {
            return root.`val`
        }

        return kthSmallest(root.right, k - leftLen - 1)
    }

    private fun len(root: TreeNode?) : Int {
        if(root == null) {
            return 0
        }

        return 1 + len(root.left) + len(root.right)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}