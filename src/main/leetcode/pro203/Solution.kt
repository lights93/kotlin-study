package pro203

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

// https://leetcode.com/problems/remove-linked-list-elements/
class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if(head == null) {
            return null
        }

        if (head.`val` == `val`) {
            return removeElements(head.next, `val`)
        }

        head.next = removeElements(head.next, `val`)
        return head
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
