package pro1202

import java.util.PriorityQueue

class Solution {
    fun smallestStringWithSwaps(s: String, pairs: List<List<Int>>): String {
        val parent = IntArray(s.length) { it }

        for (pair in pairs) {
            val parent1 = find(parent, pair[0])
            val parent2 = find(parent, pair[1])
            if(parent1 < parent2) {
                parent[parent1] = parent2
            } else {
                parent[parent2] = parent1
            }
        }

        val map = HashMap<Int, PriorityQueue<Char>>()

        for ((index, c) in s.withIndex()) {
            val key = find(parent, index)
            map.putIfAbsent(key, PriorityQueue<Char>())
            map[key]!!.add(c)
        }

        val answer = StringBuilder(s.length)
        for ((index, c) in s.withIndex()) {
            val key = find(parent, index)
            answer.append(map[key]!!.poll())
        }

        return answer.toString()
    }

    private fun find(parent : IntArray, index: Int) : Int {
        var idx = index
        while (parent[idx] != idx) {
            idx = parent[idx]
        }

        return idx
    }
}
