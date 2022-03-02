package pro78

// https://leetcode.com/problems/subsets/
class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        return subsets(nums, 0, emptyList())
    }

    private fun subsets(nums: IntArray, idx: Int, list : List<Int>) : List<List<Int>> {
        val answer = mutableListOf<List<Int>>()

        answer.add(list)

        for (i in idx until nums.size) {
            val newList = list + nums[i]
            answer.addAll(subsets(nums, i + 1, newList))
        }

        return answer
    }
}