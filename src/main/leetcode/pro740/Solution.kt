package pro740

import java.util.TreeMap

// https://leetcode.com/problems/delete-and-earn/
class Solution {
    fun deleteAndEarn(nums: IntArray): Int {
        val map = nums.toList()
                .groupingBy { it }
//                .fold(0) { accumulator: Int, element: Int -> accumulator + element }
                .aggregate { _: Int, accumulator: Int?, element: Int, first: Boolean ->
                    if(first) {
                        element
                    } else {
                        accumulator!! + element
                    }
                }
                .toSortedMap()

        val dp = TreeMap<Int, Int>()

        for (entry in map) {
            val key = entry.key
            val value : Int = entry.value!!

            val floorKey = dp.floorKey(key - 2)
            var prevMax = 0
            if(floorKey != null) {
                prevMax = dp.getOrDefault(floorKey, 0)
            }

            dp[key] = maxOf(dp.getOrDefault(key - 1, 0), prevMax + value)
        }

        return dp.lastEntry().value
    }
}