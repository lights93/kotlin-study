package pro90

// https://leetcode.com/problems/subsets-ii/
class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        return solve(nums, 0, emptyList())
    }

    private fun solve(nums: IntArray, idx: Int, list : List<Int>) : List<List<Int>> {
        val answer = mutableListOf<List<Int>>()

        answer.add(list)

        for (i in idx until nums.size) {
            if(i > idx && nums[i] == nums[i - 1]) {
                continue
            }
            val newList = list + nums[i]
            answer.addAll(solve(nums, i + 1, newList))
        }

        return answer
    }
}