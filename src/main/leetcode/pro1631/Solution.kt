package pro1631

import kotlin.math.abs

// https://leetcode.com/problems/path-with-minimum-effort/
// TLE ㅠㅠ
class Solution {
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        return solve(heights, 0, 0, HashMap(), 0)
    }

    private fun solve(heights: Array<IntArray>, i: Int, j: Int, map: HashMap<Pair<Int, Int>, Int>, current: Int): Int {
        val temp = map.getOrDefault(Pair(i, j), Int.MAX_VALUE)
        if(temp <= current) {
            return temp
        }

        map[Pair(i,j)] = current
        if (i == heights.size - 1 && j == heights[0].size - 1) {
            return current
        }

        var answer = Int.MAX_VALUE
        if (i > 0) {
            val next = maxOf(current, abs(heights[i - 1][j] - heights[i][j]))
            map[Pair(i - 1, j)] = next
            answer = minOf(solve(heights, i - 1, j, map, next), answer)
        }

        if (i < heights.size - 1) {
            val next = maxOf(current, abs(heights[i + 1][j] - heights[i][j]))
            map[Pair(i + 1, j)] = next
            answer = minOf(solve(heights, i + 1, j, map, next), answer)
        }

        if (j > 0) {
            val next = maxOf(current, abs(heights[i][j - 1] - heights[i][j]))
            map[Pair(i, j - 1)] = next
            answer = minOf(solve(heights, i, j - 1, map, next), answer)
        }

        if (j < heights[0].size - 1) {
            val next = maxOf(current, abs(heights[i][j + 1] - heights[i][j]))
            map[Pair(i, j + 1)] = next
            answer = minOf(solve(heights, i, j + 1, map, next), answer)
        }

        return answer
    }
}