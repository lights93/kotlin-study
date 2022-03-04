package pro39

// https://leetcode.com/problems/combination-sum/
class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> =
            solve(candidates, target, emptyList(), 0, 0)

    private fun solve(candidates: IntArray, target: Int, list: List<Int>, sum: Int, idx: Int): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        if (sum == target) {
            answer.add(list)
            return answer
        }

        if (sum > target) {
            return answer
        }

        for (i in idx until candidates.size) {
            answer.addAll(solve(candidates, target, list + candidates[i], sum + candidates[i], i))
        }

        return answer
    }
}