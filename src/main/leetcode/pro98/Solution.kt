package pro98

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

// https://leetcode.com/problems/validate-binary-search-tree/
class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        return isValidBST(root.left, null, root.`val`) && isValidBST(root.right, root.`val`, null)
    }

    private fun isValidBST(root: TreeNode?, minValue: Int?, maxValue: Int?): Boolean {
        if (root == null) {
            return true
        }

        println(minValue)
        println(maxValue)
        println(root.`val`)
        println(root.left)
        println(root.right)
        println()


        if (maxValue != null && root.`val` >= maxValue) {
            return false
        }

        if (minValue != null && root.`val` <= minValue) {
            return false
        }

        val newMaxValue = if (maxValue == null) {
            root.`val`
        } else {
            minOf(maxValue, root.`val`)
        }

        val newMinValue = if (minValue == null) {
            root.`val`
        } else {
            maxOf(minValue, root.`val`)
        }

        return isValidBST(root.left, minValue, newMaxValue) &&
                isValidBST(root.right, newMinValue, maxValue)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}