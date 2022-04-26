package pro1584

import java.util.PriorityQueue
import kotlin.math.abs

class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val queue = PriorityQueue<Pair<Int, Int>> { p1, p2 ->
          manhattanDistance(points[p1.first], points[p1.second]) - manhattanDistance(points[p2.first], points[p2.second])
        }

        for (i in 0 until points.size - 1) {
            for (j in i + 1 until points.size) {
                queue.add(Pair(i, j))
            }
        }

        val all = ArrayList<MutableSet<Int>>()
        var sum = 0
        var size = 0

        while (size < points.size - 1) {
            val indices = queue.poll()

            val firstSet = all.filter { it.contains(indices.first) }
                .firstOrNull()

            val secondSet = all.filter { it.contains(indices.second) }
                .firstOrNull()

            if(firstSet != null && firstSet == secondSet) {
                continue
            }

            sum += manhattanDistance(points[indices.first], points[indices.second])
            size++

            println("${indices.first}, ${indices.second}, ${sum}")

            when {
                firstSet == null && secondSet == null -> {
                    all.add(hashSetOf(indices.first, indices.second))
                }
                firstSet == null && secondSet != null -> {
                    secondSet.add(indices.first)
                }
                firstSet != null && secondSet == null -> {
                    firstSet.add(indices.second)
                }
                firstSet != null && secondSet != null -> {
                    println("${all.size}")
                    all.removeAt( all.indexOfFirst { it.contains(indices.second) })
                    firstSet.addAll(secondSet)
                    all.remove(secondSet)
                    println("${all.size}")

                }
            }
        }

        return sum
    }

    private fun manhattanDistance(point1 : IntArray, point2: IntArray): Int {
        return abs(point1[0] - point2[0]) + abs(point1[1] - point2[1])
    }
}