package pro83

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        var node = head

        while (node!!.next != null) {
            val nextNode = node.next
            if (node.`val` == nextNode!!.`val`) {
                node.next = nextNode.next
            } else {
                node = nextNode
            }
        }

        return head
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}