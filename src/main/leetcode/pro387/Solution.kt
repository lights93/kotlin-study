package pro387

// https://leetcode.com/problems/first-unique-character-in-a-string/
class Solution {
    fun firstUniqChar(s: String): Int {
        val map = mutableMapOf<Char, Int>()

        s.toCharArray().forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        s.toCharArray().forEachIndexed { idx, c ->
            val cnt = map[c]
            if (cnt == 1) {
                return idx
            }
        }

        return -1
    }
}