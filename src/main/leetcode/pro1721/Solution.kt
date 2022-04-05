package pro1721

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
class Solution {
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        if(head?.next == null) {
            return head
        }
        var beforeFastNode : ListNode? = null
        var fastNode = head

        repeat(k - 1) {
            beforeFastNode = fastNode
            fastNode = fastNode?.next
        }

        var beforeSlowNode : ListNode? = null
        var slowNode = head
        var beforeSwapNode : ListNode? = null
        var swapNode : ListNode? = null
        var cnt = 1
        while (fastNode?.next != null) {
            if(cnt == k) {
                beforeSwapNode = beforeSlowNode
                swapNode = slowNode
            }
            beforeSlowNode = slowNode
            slowNode = slowNode?.next
            beforeFastNode = fastNode
            fastNode = fastNode?.next
            cnt++
        }

        val beforeSwapNode2 = beforeSlowNode
        val swapNode2 = slowNode

        if(cnt <= k) {
            while (cnt < k) {
                cnt++
                beforeSlowNode = slowNode
                slowNode = slowNode?.next
            }
            beforeSwapNode = beforeSlowNode
            swapNode = slowNode

        }
        if(swapNode == swapNode2) {
            return head
        }

        var newHead = head


        if(swapNode?.next == swapNode2) {
            if(beforeSwapNode != null) {
                beforeSwapNode.next = swapNode2
            } else {
                newHead = swapNode2
            }
            swapNode?.next = swapNode2?.next
            swapNode2?.next = swapNode
            return newHead
        }


        if(swapNode2?.next == swapNode) {
            if(beforeSwapNode2 != null) {
                beforeSwapNode2.next = swapNode
            } else {
                newHead = swapNode
            }

            swapNode2?.next = swapNode?.next
            swapNode?.next = swapNode2
            return newHead
        }

        if(beforeSwapNode != null) {
            beforeSwapNode.next = swapNode2
        } else {
            newHead = swapNode2
        }
        val temp = swapNode2?.next
        swapNode2?.next = swapNode?.next
        if(beforeSwapNode2 != null) {
            beforeSwapNode2.next = swapNode
        } else {
            newHead = swapNode
        }
        swapNode?.next = temp

        return newHead
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}