package pro92343

// https://programmers.co.kr/learn/courses/30/lessons/92343
class Solution {
    private lateinit var info: IntArray
    private lateinit var graph: Map<Int, Set<Int>>
    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        graph = edges.groupBy { it[0] }
            .mapValues { it.value.map { arr -> arr[1] }.toSet() }
            .toMap()
        this.info = info

        val nums = graph.getOrDefault(0, setOf())

        var max = 1

        for (num in nums) {
            max = maxOf(max, solve(num, 1, 0, nums))
        }

        return max
    }

    private fun solve(idx: Int, lamb: Int, wolf: Int, nums: Set<Int>): Int {
        val newLamb = lamb + (info[idx] xor 1)
        val newWolf = wolf + info[idx]
        if (newLamb <= newWolf) {
            return 0
        }
        var max = newLamb

        val newNums = graph.getOrDefault(idx, mutableSetOf()).toMutableSet()
        newNums.addAll(nums)
        newNums.remove(idx)


        for (newNum in newNums) {
            max = maxOf(solve(newNum, newLamb, newWolf, newNums), max)
        }

        return max
    }
}