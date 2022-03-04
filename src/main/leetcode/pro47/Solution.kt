package pro47

class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        return solve(nums, emptyList(), emptySet()).toList()
    }

    private fun solve(nums: IntArray, list : List<Int>, used : Set<Int>) : Set<List<Int>> {
        val answer = mutableSetOf<List<Int>>()

        if(used.size == nums.size) {
            answer.add(list)
            return answer
        }

        for ((index, num) in nums.withIndex()) {
            if(used.contains(index)) {
                continue
            }

            answer.addAll(solve(nums, list + num, used + index))
        }

        return answer
    }
}