package pro40

// https://leetcode.com/problems/combination-sum-ii/
class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        return solve(candidates, target, emptyList(), 0, 0).toList()
    }

    private fun solve(candidates: IntArray, target: Int, list: List<Int>, sum: Int, idx: Int): Set<List<Int>> {
        val answer = mutableSetOf<List<Int>>()
        if (sum == target) {
            answer.add(list)
            return answer
        }

        if (sum > target || idx >= candidates.size) {
            return answer
        }

        for (i in idx until candidates.size) {
            if (i != idx && i > 0 && candidates[i] == candidates[i - 1]) {
                continue
            }
            answer.addAll(solve(candidates, target, list + candidates[i], sum + candidates[i], i + 1))
        }

        return answer
    }
}