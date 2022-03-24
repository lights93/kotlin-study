package pro881

import java.util.TreeMap

// https://leetcode.com/problems/boats-to-save-people/
class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        val countMap = people.toTypedArray()
            .groupingBy { it }
            .eachCount()

        val treeMap : TreeMap<Int, Int> = TreeMap(countMap)

        var answer = 0

        while (treeMap.size > 0) {
            var remain = limit

            var key = treeMap.firstKey()
            treeMap[key] = treeMap.getOrDefault(key, 0) - 1
            if(treeMap[key]!! <= 0) {
                treeMap.remove(key)
            }

            remain -= key

            if(remain > 0 && treeMap.floorKey(remain) != null) {
                key = treeMap.floorKey(remain)
                treeMap[key] = treeMap.getOrDefault(key, 0) - 1
                if(treeMap[key]!! <= 0) {
                    treeMap.remove(key)
                }

                remain -= key
            }

            answer++
        }

        return answer
    }
}