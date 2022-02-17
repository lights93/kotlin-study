package pro82

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        if (head.next == null) {
            return head
        }

        if (head.`val` != head.next!!.`val`) {
            head.next = deleteDuplicates(head.next)
            return head
        }

        while (head.next != null && head.`val` == head.next!!.`val`) {
            head.next = head.next!!.next
        }

        return deleteDuplicates(head.next)
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}