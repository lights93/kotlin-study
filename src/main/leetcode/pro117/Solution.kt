package pro117

import java.util.*

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
class Solution {

    fun connect(root: Node?): Node? {
        if(root == null) {
            return null
        }

        var current = root
        var head :Node? = null
        var prev :Node? = null

        while (current != null) {
            if(current.left != null) {
                if(prev == null) {
                    head = current.left
                } else {
                    prev.next = current.left
                }
                prev = current.left
            }

            if(current.right != null) {
                if(prev == null) {
                    head = current.right
                } else {
                    prev.next = current.right
                }
                prev = current.right
            }

            current = current.next
        }

        connect(head)

        return root
    }
}

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}