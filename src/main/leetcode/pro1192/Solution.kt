package pro1192

// https://leetcode.com/problems/critical-connections-in-a-network/
// https://en.wikipedia.org/wiki/Tarjan%27s_strongly_connected_components_algorithm
// https://leetcode.com/problems/critical-connections-in-a-network/discuss/399827/Java-DFS-Solution-similar-to-Tarjan-maybe-easier-to-understand
class Solution {
    private var graph: Map<Int, List<Int>> = mapOf()
    private var index = 0
    private var indexes = intArrayOf()
    private val answer: MutableList<List<Int>> = mutableListOf()

    fun criticalConnections(n: Int, connections: List<List<Int>>): List<List<Int>> {
        graph = connections.flatMap {
            listOf(Pair(it[0], it[1]), Pair(it[1], it[0]))
        }.groupBy({ it.first }, { it.second })

        indexes = IntArray(n) { -1 }

        dfs(0, -1)
        return answer
    }

    private fun dfs(i: Int, parent: Int): Int {
        if (indexes[i] != -1) {
            return indexes[i]
        }
        indexes[i] = index
        index++

        val list = graph.getOrDefault(i, listOf())

        var minIndex = Int.MAX_VALUE
        for (dest in list) {
            if (dest == parent) {
                continue
            }

            minIndex = minOf(dfs(dest, i), minIndex)
        }

        if (minIndex >= indexes[i] && parent >= 0) {
            answer.add(listOf(i, parent))
        }

        return minOf(indexes[i], minIndex)
    }
}