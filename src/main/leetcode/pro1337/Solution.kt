package pro1337

// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
class Solution {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val list = mutableListOf<Military>()

        mat.withIndex().forEach { (index, nums) ->
            list += Military(index, nums.filter { it == 1 }.size)
        }

        list.sort()

        return list.take(k).map { it.idx }.toIntArray()
    }
}

class Military(
    val idx: Int,
    val num: Int
) : Comparable<Military> {
    override fun compareTo(other: Military): Int {
        if (num.compareTo(other.num) != 0) {
            return num.compareTo(other.num)
        }

        return idx.compareTo(other.idx)
    }
}