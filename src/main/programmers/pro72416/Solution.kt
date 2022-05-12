package pro72416

// https://programmers.co.kr/learn/courses/30/lessons/72416
class Solution {
    fun solution(sales: IntArray, links: Array<IntArray>): Int {
        val teamToMember = mutableMapOf<Int, MutableSet<Int>>()
        for (link in links) {
            val members = teamToMember.getOrDefault(link[0], mutableSetOf())
            members.add(link[1])
            teamToMember[link[0]] = members
        }

        val dp = Array(sales.size) {
            intArrayOf(0, sales[it])
        }

        return solve(sales, teamToMember, 1, dp)
    }

    private fun solve(
        sales: IntArray,
        teamToMember: MutableMap<Int, MutableSet<Int>>,
        current: Int,
        dp: Array<IntArray>
    ): Int {
        if (!teamToMember.containsKey(current)) {
            return 0
        }
        val members = teamToMember[current]!!

        var sum = 0

        var isExist = false
        var min = Int.MAX_VALUE
        for (member in members) {
            sum += solve(sales, teamToMember, member, dp)
            if (isExist) {
                continue
            }
            if (dp[member - 1][0] > dp[member - 1][1]) {
                isExist = true
            }
            min = minOf(dp[member - 1][1] - dp[member - 1][0], min)
        }

        dp[current - 1][1] = sum + sales[current - 1]
        if (isExist) {
            dp[current - 1][0] = sum
        } else {
            dp[current - 1][0] = sum + min
        }

        return minOf(dp[current - 1][1], dp[current - 1][0])
    }
}