package pro1046

import java.util.*

// https://leetcode.com/problems/last-stone-weight/
class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val queue = stones.toCollection(PriorityQueue<Int>(Collections.reverseOrder()))

        while (queue.size > 1) {
            val diff = queue.poll() - queue.poll()
            if (diff != 0) {
                queue.add(diff)
            }
        }

        if (queue.size == 0) {
            return 0
        }

        return queue.poll()
    }
}