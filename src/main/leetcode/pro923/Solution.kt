package pro923

import java.math.BigInteger
import java.util.SortedMap

// https://leetcode.com/problems/3sum-with-multiplicity/
class Solution {
    companion object {
        const val MODULO = 1_000_000_007
    }

    fun threeSumMulti(arr: IntArray, target: Int): Int {
        val countMap = arr.toTypedArray()
            .groupingBy { it }
            .eachCount()
            .toSortedMap()
        return solve(countMap, target, 0, 1, arrayListOf())
    }

    fun solve(countMap: SortedMap<Int, Int>, remain: Int, start: Int, multiple: Int, list: MutableList<Int>): Int {
        if(remain < 0) {
            return 0
        }

        if(list.size == 2) {
            if(remain >= start && countMap.containsKey(remain) && countMap[remain]!! > 0) {
                val set = HashSet<Int>(list)
                set.add(remain)
                val divide = when (set.size) {
                    3 -> {
                        1
                    }
                    2 -> {
                        2
                    }
                    else -> {
                        6
                    }
                }

                println("$multiple ${countMap[remain]}")
                return BigInteger.valueOf(multiple.toLong())
                    .multiply(BigInteger.valueOf(countMap[remain]!!.toLong()))
                    .divide(BigInteger.valueOf(divide.toLong()))
                    .remainder(BigInteger.valueOf(MODULO.toLong()))
                    .toInt()

            }
            return 0
        }

        var sum = 0
        for ((num, cnt) in countMap) {
            if(num < start || cnt <= 0) {
                continue
            }
            countMap[num] = cnt - 1
            list.add(num)
            sum += solve(countMap, remain - num, num, multiple * cnt, list)
            sum %= MODULO
            list.removeAt(list.lastIndex)
            countMap[num] = cnt

        }
        return sum
    }
}