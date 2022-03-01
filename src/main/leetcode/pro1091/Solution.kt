package pro1091

import java.util.*

class Solution {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        var result = 0
        val queue: Queue<Pair<Int, Int>> = LinkedList()

        queue.add(Pair(0, 0))

        while (queue.isNotEmpty()) {
            result++
            val size = queue.size
            for (i in 0 until size) {
                val poll = queue.poll()
                if (poll.first < 0 || poll.first >= grid.size || poll.second < 0 || poll.second >= grid.size) {
                    continue
                }
                if (grid[poll.first][poll.second] == 1) {
                    continue
                }

                if (poll.first == grid.size - 1 && poll.second == grid.size - 1) {
                    return result
                }

                grid[poll.first][poll.second] = 1

                queue.add(Pair(poll.first + 1, poll.second + 1))
                queue.add(Pair(poll.first + 1, poll.second))
                queue.add(Pair(poll.first + 1, poll.second - 1))
                queue.add(Pair(poll.first, poll.second + 1))
                queue.add(Pair(poll.first, poll.second - 1))
                queue.add(Pair(poll.first - 1, poll.second + 1))
                queue.add(Pair(poll.first - 1, poll.second))
                queue.add(Pair(poll.first - 1, poll.second - 1))
            }
        }

        return -1
    }

}