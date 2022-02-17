package pro15

// https://leetcode.com/problems/3sum/
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val map = nums.toList()
            .groupingBy { it }.eachCount()

        val listSet = mutableSetOf<List<Int>>()
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                val sum = nums[i] + nums[j]
                if (map.containsKey(-sum)) {
                    val cnt = map[-sum]

                    if (cnt!! > 2) {
                        listSet.add(listOf(nums[i], nums[j], -sum).sorted())
                        continue
                    }
                    if (cnt == 2 && sum != 0) {
                        listSet.add(listOf(nums[i], nums[j], -sum).sorted())
                        continue
                    }

                    if (-sum != nums[i] && -sum != nums[j]) {
                        listSet.add(listOf(nums[i], nums[j], -sum).sorted())
                    }
                }
            }
        }

        return listSet.toList()
    }
}