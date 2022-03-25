package pro1029

// https://leetcode.com/problems/two-city-scheduling/
class Solution {
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        costs.sortBy {
            it[0] - it[1] }


        costs.forEach { println("${it[0]} ${it[1]}") }


        var sum = 0
        for (idx in 0 until costs.size / 2) {
            sum += costs[idx][0]
            sum += costs[costs.size - 1 - idx][1]
        }

        return sum
    }
}