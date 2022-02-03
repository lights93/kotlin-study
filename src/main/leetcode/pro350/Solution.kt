package pro350

// https://leetcode.com/problems/intersection-of-two-arrays-ii/
class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val map = nums1
            .groupBy { it }
            .mapValues { it.value.count() }
            .toMutableMap()

        val list = mutableListOf<Int>()

        nums2.forEach {
            val cnt = map.getOrDefault(it, 0)
            if (cnt > 0) {
                list.add(it)
                map[it] = cnt - 1
            }
        }

        return list.toIntArray()
    }
}