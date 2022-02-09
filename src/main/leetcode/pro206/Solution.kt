package pro206

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

// https://leetcode.com/problems/reverse-linked-list/
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        var newHead = head

        while (head.next != null) {
            val nextNode = head.next
            head.next = nextNode!!.next

            nextNode.next = newHead
            newHead = nextNode
        }

        return newHead
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}