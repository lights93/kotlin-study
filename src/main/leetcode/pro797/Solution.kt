package pro797

class Solution {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        return solve(graph, 0, emptyList())
    }

    private fun solve(graph: Array<IntArray>, idx: Int, path: List<Int>): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        if (idx == graph.size - 1) {
            result.add(path + idx)
            return result
        }

        for (i in graph[idx]) {
            result.addAll(solve(graph, i, path + idx))
        }

        return result
    }
}