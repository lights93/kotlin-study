package pro322

import java.util.LinkedList
import java.util.Queue

// https://leetcode.com/problems/coin-change/
class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if(amount == 0) {
            return 0
        }

        coins.sortDescending()

        val queue : Queue<Int> = LinkedList()
        queue.add(0)

        var answer = 1
        var used = mutableSetOf<Int>()
        while (queue.isNotEmpty()) {
            println(queue)
            val size = queue.size
            repeat(size) {
                val poll = queue.poll()
                for (coin in coins) {
                    val temp = poll + coin
                    if(temp == amount) {
                        return answer
                    }
                    if(used.contains(temp) || temp > amount) {
                        continue
                    }
                    used.add(temp)
                    queue.add(temp)
                }
            }
            answer++
        }

        return -1
    }

}