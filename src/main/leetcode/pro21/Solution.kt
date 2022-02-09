package pro21

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

// https://leetcode.com/problems/merge-two-sorted-lists/
class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val prevHead = ListNode(0)
        var node = prevHead

        var head1 = list1
        var head2 = list2

        while (head1 != null && head2 != null) {
            when {
                head1.`val` < head2.`val` -> {
                    node.next = head1
                    head1 = head1.next
                }
                else -> {
                    node.next = head2
                    head2 = head2.next
                }
            }
            node = node.next!!
        }

        if (head1 == null) {
            node.next = head2
        } else {
            node.next = head1
        }

        return prevHead.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
