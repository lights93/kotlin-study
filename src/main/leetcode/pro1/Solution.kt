package pro1

// https://leetcode.com/problems/two-sum/
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numberIndexMap = hashMapOf<Int, Int>()

        nums.forEachIndexed { index, num ->
            val diff = target - num
            if (numberIndexMap.containsKey(diff)) {
                val firstIndex = numberIndexMap[diff]
                return intArrayOf(firstIndex!!, index)
            }
            numberIndexMap[num] = index
        }

        throw RuntimeException()
    }
}